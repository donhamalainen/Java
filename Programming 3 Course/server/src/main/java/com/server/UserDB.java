package com.server;

import java.io.File;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import org.apache.commons.codec.digest.Crypt;
import org.json.JSONObject;

public class UserDB {
    // Attributes
    private Connection dbConnection = null;
    private static UserDB dbInstance = null;
    private SecureRandom secureRandom = new SecureRandom();

    public static synchronized UserDB getInstance() {
        if (dbInstance == null) {
            dbInstance = new UserDB();
        }
        return dbInstance;
    }

    private UserDB() {
        try {
            open("UserDB.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean initializeDatabase() throws SQLException {
        if (dbConnection != null) {
            String createUserTable = """
                    CREATE TABLE users (username VARCHAR(50) NOT NULL,
                     password VARCHAR(50) NOT NULL, email VARCHAR(50),
                      userNickname VARCHAR(50), primary key(username))
                      """;
            Statement createStatement = dbConnection.createStatement();
            createStatement.executeUpdate(createUserTable);
            createStatement.close();

            System.out.println("Database created succesfully");
            return true;
        }
        System.out.println("ERR: Database not created succesfully");
        return false;

    }

    public void closeDB() throws SQLException {
        if (dbConnection != null) {
            dbConnection.close();
            dbConnection = null;
            System.out.println("Database connection closed succesfully");
        }
    }

    public boolean setUser(JSONObject user) throws SQLException {
        if (checkIfUserExists(user.getString("username"))) {
            return false;
        }
        // Secure Random
        System.out.println("Encoding the user password");
        byte bytes[] = new byte[13];
        secureRandom.nextBytes(bytes);
        String saltBytes = new String(Base64.getEncoder().encode(bytes));
        String salt = "$6$" + saltBytes;
        String hashedPassword = Crypt.crypt(user.getString("password"), salt);

        // Secure Random
        String setUserString = "INSERT INTO users " + "VALUES('" + user.getString("username") + "','" + hashedPassword
                + "','" + user.getString("email") + "','" + user.getString("userNickname") + "')";

        Statement createStatement = dbConnection.createStatement();
        createStatement.executeUpdate(setUserString);
        createStatement.close();
        return true;
    }

    public boolean checkIfUserExists(String username) throws SQLException {

        Statement queryStatement = null;
        ResultSet rs;

        String checkUser = "SELECT username FROM users where username = '" + username + "'";
        System.out.println("Checking user");

        queryStatement = dbConnection.createStatement();
        rs = queryStatement.executeQuery(checkUser);

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean authenticateUser(String username, String password) throws SQLException {
        System.out.println("Entering authenticateUser method");
        Statement queryStatement = null;
        ResultSet rs;

        String getMessageString = "SELECT username, password FROM users WHERE username = '" + username + "'";

        queryStatement = dbConnection.createStatement();

        rs = queryStatement.executeQuery(getMessageString);

        if (!rs.next()) {
            System.out.println("User not found");
            return false;
        } else {
            // Hashed password authentication
            String hashedPassword = rs.getString("password");
            if (hashedPassword.equals(Crypt.crypt(password, hashedPassword))) {
                return true;
            } else {
                return false;
            }

        }
    }

    public void open(String dbName) throws SQLException {

        boolean exit;

        File file = new File(dbName);
        exit = file.exists();

        String database = "jdbc:sqlite:" + dbName;
        dbConnection = DriverManager.getConnection(database);
        if (!exit) {
            initializeDatabase();
        }

    }
}
