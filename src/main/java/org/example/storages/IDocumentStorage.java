package org.example.storages;

import java.sql.SQLException;

public interface IDocumentStorage {

    void prepare() throws SQLException;
    void insert(String docType, byte[] docBody, String sender, String recipient, String fileName) throws SQLException, ClassNotFoundException;

}
