package com.server;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.BasicAuthenticator;

public class UserAuthenticator extends BasicAuthenticator {
    private UserDB db = null;
    User user;

    public UserAuthenticator(String realm) {
        super(realm);
        db = UserDB.getInstance();
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        boolean valid;
        System.out.println("Checking user: " + username + " creadentials");
        try {
            valid = db.authenticateUser(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return valid;
    }

    public boolean addUser(String username, String password, String email, String nickname)
            throws SQLException, JSONException {

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || nickname.isEmpty()) {
            return false;
        }

        boolean result = db.setUser(new JSONObject().put("username", username).put("password", password)
                .put("email", email).put("userNickname", nickname));
        if (!result) {
            System.out.println("Registering user " + username + " failed");
            return false;
        }
        user = new User(username, password, email, nickname);
        return true;
    }

}