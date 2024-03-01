package com.server;

import com.sun.net.httpserver.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.util.concurrent.Executors;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManagerFactory;

public class Server {
    // SSL
    private static SSLContext myServerSSLContext(String file, String password) throws Exception {

        // String file, String pass
        char[] passphrase = password.toCharArray();
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(file), passphrase);

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, passphrase);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ks);

        SSLContext ssl = SSLContext.getInstance("TLS");
        ssl.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        return ssl;
    }

    public static void main(String[] args) throws Exception {
        try {
            // create the http server to port 8001 with default logger
            HttpsServer server = HttpsServer.create(new InetSocketAddress(8001), 0);
            SSLContext sslContext = myServerSSLContext(args[0], args[1]);
            // server https configuration
            server.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
                public void configure(HttpsParameters params) {
                    InetSocketAddress remote = params.getClientAddress();
                    SSLContext c = getSSLContext();
                    SSLParameters sslparams = c.getDefaultSSLParameters();
                    params.setSSLParameters(sslparams);

                }
            });

            HttpContext finalContext = server.createContext("/info", new Handler());

            UserAuthenticator auth = new UserAuthenticator("info");
            finalContext.setAuthenticator(auth);
            server.createContext("/registration", new RegisterationHandler(auth));

            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("\nServer started successfully on port 8001...");

        } catch (FileNotFoundException e) {
            // Certificate file not found!
            e.printStackTrace();
            System.out.println("\nCertificate not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}