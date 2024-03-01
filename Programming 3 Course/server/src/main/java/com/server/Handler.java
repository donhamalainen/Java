package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Handler implements HttpHandler {

    // Attributes
    MessageDB db = MessageDB.getInstance();

    // Methods
    @SuppressWarnings("deprecation")
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Request handled in thread " + Thread.currentThread().getId());
        // POST
        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            System.out.println("\nEntering POST Handler");
            handleResponsePOST(exchange);
            System.out.println("\nENDING POST Handler");
            // GET
        } else if (exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            System.out.println("\nENTERING GET Handler");
            handleResponseGET(exchange);
            System.out.println("\nENDING GET Handler");
            // Others
        } else {
            // Inform user here that only POST and GET functions are supported and send an
            // error code 400 with a message “Not supported” (witouth the “).
            System.out.println("\nOnly POST and GET functions are supported in Handler");
            sendResponse(exchange, "Not supported", 400);
        }
    }

    // Handle GET and POST
    @SuppressWarnings("resource")
    private void handleResponsePOST(HttpExchange exchange) throws IOException {
        // Initialized
        InputStream stream = exchange.getRequestBody();
        String text = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).lines()
                .collect(Collectors.joining("\n"));

        try {
            JSONObject obj = new JSONObject(text);
            System.out.println(obj);

            db.setMessage(obj, exchange.getPrincipal().getUsername());

            exchange.sendResponseHeaders(200, -1);
        } catch (SQLException e) {
            e.printStackTrace();
            exchange.sendResponseHeaders(403, -1);
        } catch (JSONException je) {
            je.printStackTrace();
            exchange.sendResponseHeaders(403, -1);
        } catch (DateTimeParseException dtpe) {
            dtpe.printStackTrace();
            exchange.sendResponseHeaders(403, -1);
        }

    }

    private void handleResponseGET(HttpExchange exchange) throws IOException {
        String response = "";

        try {
            JSONArray responseMessage = new JSONArray();
            responseMessage = db.getMessage();
            if (responseMessage.isEmpty()) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }
            response = responseMessage.toString();
            byte[] bytes = response.getBytes("UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (SQLException e) {
            e.printStackTrace();
            exchange.sendResponseHeaders(403, -1);
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
