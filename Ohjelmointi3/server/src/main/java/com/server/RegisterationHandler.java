package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.*;

public class RegisterationHandler implements HttpHandler {

    private UserAuthenticator auth;

    public RegisterationHandler(UserAuthenticator auth) {
        this.auth = auth;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            System.out.println("\nPOST request detected in registration");
            handleResponsePOST(exchange);
        } else {
            System.out.println("\nRequest is not supported in registration");
            sendResponse(exchange, "Not supported", 400);
        }
    }

    @SuppressWarnings("resource")
    private void handleResponsePOST(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getRequestHeaders();
        String contentType = "";
        JSONObject obj = null;
        // Check the Content-Type available
        if (headers.containsKey("Content-Type")) {
            System.out.println("Content-Type header detected in registration");
            contentType = headers.get("Content-Type").get(0);
        } else {
            System.out.println("Content-Type header not detected in registration");
            sendResponse(exchange, "No Content-Type in request", 411);
            return;
        }

        try {
            // Check the Application/json in Content-Type
            if (contentType.equalsIgnoreCase("application/json")) {
                System.out.println("Application/json detected in registration");
                InputStream stream = exchange.getRequestBody();
                String newUser = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).lines()
                        .collect(Collectors.joining("\n"));
                stream.close();

                // Check the user credential
                if (newUser == null || newUser.length() == 0) {
                    System.out.println("No user credentials");
                    sendResponse(exchange, "No user credentials", 412);
                    return;
                } else {
                    System.out.println("Trying parse the JSON in registration");
                    try {
                        obj = new JSONObject(newUser);
                        System.out.println("JSON parsed successfully");
                    } catch (JSONException e) {
                        System.out.println("Got JSON exception: " + e.getStackTrace());
                    }

                    // Check the JSON Data
                    if (obj.getString("username").length() == 0 || obj.getString("password").length() == 0) {
                        System.out.println("No proper user credentials");
                        sendResponse(exchange, "No proper user credentials", 413);
                        return;
                    } else {
                        System.out.println("Trying to register the user");
                        if (!auth.addUser(obj.getString("username"), obj.getString("password"), obj.getString("email"),
                                obj.getString("userNickname"))) {
                            System.out.println("This user already exists");
                            sendResponse(exchange, "This user already exists", 405);
                            return;
                        } else {
                            System.out.println("User registered succesfully");
                            sendResponse(exchange, "User registered succesfully", 200);
                        }
                    }
                }
            } else {
                System.out.println("Application/json is not detected in registration");
                sendResponse(exchange, "Request is not include application/json ", 407);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Send response
    private void sendResponse(HttpExchange exchange, String response, Integer num) throws IOException {
        exchange.sendResponseHeaders(num, response.getBytes("UTF-8").length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.flush();
        os.close();
    }
}