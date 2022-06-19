package org.example;

import com.sun.net.httpserver.HttpServer;
import org.example.server.MyHandler;
import org.example.storages.DocumentStorage;
import org.example.storages.IDocumentStorage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;


public class HttpServer2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {



        int port = 8080;
        IDocumentStorage storage = new DocumentStorage("jdbc:mysql://localhost:3306", "bestuser", "bestuser");
        storage.prepare();

        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            System.out.println("Server started");
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/docs", new MyHandler(storage));
        server.setExecutor(null);
        server.start();
    }

}
