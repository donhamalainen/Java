package com.server;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

public class MessageDB {
    // Attributes
    private Connection dbConnection = null;
    private static MessageDB dbInstance = null;
    private UserDB userDB = null;

    // Constructors
    public static synchronized MessageDB getInstance() {
        System.out.println("\nInitializing database connection");
        if (dbInstance == null) {
            System.out.println("Message Database create connection");
            dbInstance = new MessageDB();
        }
        System.out.println("Message Database instance is already initialized");
        return dbInstance;
    }

    private MessageDB() {
        try {
            userDB = UserDB.getInstance();
            // System.out.println(userDB.getUserNickname("username"));
            open("MessageDB.db");
        } catch (SQLException e) {
            System.out.println("Message Database initialization failed");
        }
    }

    // Methods
    private boolean initializeDatabase() throws SQLException {

        if (dbConnection != null) {
            String createMessageDB = """
                    CREATE TABLE message (
                    locationName VARCHAR(500) NOT NULL,
                    locationDescription VARCHAR(500) NOT NULL,
                    locationCity VARCHAR(500) NOT NULL,
                    locationCountry VARCHAR(500) NOT NULL,
                    locationStreetAddress VARHCHAR(500) NOT NULL,
                    originalPoster VARCHAR(500),
                    originalPostingTime INTEGER,
                    latitude VARCHAR(500),
                    longitude VARCHAR(500))
                    """;

            Statement createStatement = dbConnection.createStatement();
            createStatement.executeUpdate(createMessageDB);
            createStatement.close();
            System.out.println("Message Database created successfully");
            return true;
        }
        System.out.println("Creating message database failed");
        return false;
    }

    public void close() throws SQLException {
        if (dbConnection != null) {
            dbConnection.close();
            System.out.println("Connection closed successfully");
            dbConnection = null;
        }
    }

    public void setMessage(JSONObject message, String userNickname) throws SQLException {
        System.out.println("Entering MessageDB setMessage");

        String location = message.getString("locationName");
        String description = message.getString("locationDescription");
        String city = message.getString("locationCity");
        String country = message.getString("locationCountry");
        String address = message.getString("locationStreetAddress");

        // Haetaan nickname userDB:stä
        String originalPoster = userDB.getUserNickname(userNickname);

        String postingTime = message.getString("originalPostingTime");
        String latitude = message.optString("latitude");
        String longitude = message.optString("longitude");

        UserMessage messageTime = new UserMessage(location, description, city, country, address, originalPoster,
                postingTime, latitude, longitude);

        long unixLong = messageTime.dateAsInt();
        // System.out.println("Aika unix aikana: " + unixLong);

        messageTime.getOriginalPostingTime();

        String setMessageString = "insert into message " + "VALUES('" + location + "','" + description + "','" + city
                + "','" + country + "','" + address + "','" + originalPoster + "','" + unixLong
                + "','"
                + latitude
                + "','" + longitude + "')";

        Statement createStatement = dbConnection.createStatement();
        createStatement.executeUpdate(setMessageString);
        createStatement.close();
    }

    public JSONArray getMessage() throws SQLException {
        Statement quaryStatement = null;
        JSONArray array = new JSONArray();

        String getMessageString = """
                select locationName,
                locationDescription,
                locationCity,
                locationCountry,
                locationStreetAddress,
                 originalPoster,
                  originalPostingTime,
                  latitude,
                  longitude
                  from message""";

        quaryStatement = dbConnection.createStatement();
        ResultSet rs = quaryStatement.executeQuery(getMessageString);

        while (rs.next()) {
            JSONObject obj = new JSONObject();
            ZonedDateTime time = ZonedDateTime.ofInstant(Instant.ofEpochMilli(rs.getLong("originalPostingTime")),
                    ZoneOffset.UTC);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

            obj.put("locationName", rs.getString("locationName"));
            obj.put("locationDescription", rs.getString("locationDescription"));
            obj.put("locationCity", rs.getString("locationCity"));
            obj.put("locationCountry", rs.getString("locationCountry"));
            obj.put("locationStreetAddress", rs.getString("locationStreetAddress"));
            obj.put("originalPoster", rs.getString("originalPoster"));
            obj.put("originalPostingTime", time.format(formatter));

            if (!rs.getString("latitude").isEmpty() && !rs.getString("longitude").isEmpty()) {
                obj.put("latitude", rs.getDouble("latitude"));
                obj.put("longitude", rs.getDouble("longitude"));
            }
            System.out.println("JSON Array" + "\n\n" + array.toString());
            array.put(obj);
        }

        return array;
    }

    public void open(String fileName) throws SQLException {
        boolean fileExists;

        File file = new File(fileName);
        fileExists = file.exists();
        {
            String database = "jdbc:sqlite:" + fileName;
            dbConnection = DriverManager.getConnection(database);
            if (!fileExists) {
                initializeDatabase();
            }
        }
    }
}