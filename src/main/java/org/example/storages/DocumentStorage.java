package org.example.storages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;

public class DocumentStorage implements IDocumentStorage {
    private final String url;
    private final String user;
    private final String pass;

    public DocumentStorage(String url, String user, String pass) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.pass = pass;
        Class.forName("com.mysql.cj.jdbc.Driver"); //  com.mysql.jdbc.Driver
    }

    @Override
    public void prepare() throws SQLException {

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            statement.execute("drop table if exists test.docs");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS test.docs (" +
                    "doc_id int NOT NULL AUTO_INCREMENT," +
                    "doc_type varchar(45) DEFAULT NULL," +
                    "doc_body longblob," +
                    "sender varchar(255) DEFAULT NULL," +
                    "recipient varchar(255) DEFAULT NULL," +
                    "file_name varchar(255) DEFAULT NULL," +
                    "PRIMARY KEY (doc_id), UNIQUE KEY doc_id_UNIQUE (doc_id))");
        }
        System.out.println("table created");
    }

    public void insert(String docType, byte[] docBody, String sender, String recipient, String fileName) throws SQLException, ClassNotFoundException {

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
             String query = "INSERT INTO test.docs (doc_type, doc_body, sender, recipient, file_name) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement prepared = connection.prepareStatement(query)) {
                prepared.setString(1, docType);
                prepared.setBytes(2, docBody);
                prepared.setString(3, sender);
                prepared.setString(4, recipient);
                prepared.setString(5, fileName);
                prepared.executeUpdate();
            }
        }
        System.out.println("inserted to table");
    }
}
