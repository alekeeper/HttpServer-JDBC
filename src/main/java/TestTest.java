import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class TestTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

       /* List<String> list = new ArrayList<>();
        String fileName = "order.xml";
        String[] parts = fileName.split("\\.");
        for(String part: parts){
            list.add(part);
        }
        System.out.println(list.get(1));*/

        /*Gson gson = new Gson();
        String input = "{\"file_name\":\"order.xml\",\"body\":\"PE9SREVSPgogICAgPERPQ1VNRU5UTkFNRT4yMjA8L0RPQ1VNRU5UTkFNRT4KICAgIDxOVU1CRVI+NTc5NTkwODU5NjwvTlVNQkVSPgogICAgPERBVEU+MjAxNy0xMi0wNzwvREFURT4KICAgIDxIRUFEPgogICAgICAgIDxTRU5ERVI+NzYzMDAxNjQyOTk1OTwvU0VOREVSPgogICAgICAgIDxSRUNJUElFTlQ+Njg2NDA2Njk1NDYxODwvUkVDSVBJRU5UPgogICAgPC9IRUFEPgo8L09SREVSPg==\"}";

        MyFile myFile = gson.fromJson(input, MyFile.class);


        byte[] decodedBytes = Base64.getDecoder().decode(myFile.getBody());
        String decodedString = new String(decodedBytes);

        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypes(new Class[]{org.example.xml.model.Order.class});
        xstream.processAnnotations(org.example.xml.model.Order.class);
        org.example.xml.model.Order objectFromXML = (org.example.xml.model.Order) xstream.fromXML(decodedString);
        System.out.println(objectFromXML);

        //-----------------------------------------------------------------------

        String url = "jdbc:mysql://localhost:3306";
        String username = "bestuser";
        String password = "bestuser";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            statement.execute("drop table if exists test.docs");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS test.docs (" +
                    "doc_id int NOT NULL AUTO_INCREMENT," +
                    "doc_type varchar(45) DEFAULT NULL," +
                    "doc_body longblob," +
                    "sender varchar(45) DEFAULT NULL," +
                    "recipient varchar(45) DEFAULT NULL," +
                    "file_name varchar(45) DEFAULT NULL," +
                    "PRIMARY KEY (doc_id), UNIQUE KEY doc_id_UNIQUE (doc_id))");

            ResultSet resultSet = statement.executeQuery("select * from test.docs");

            String query = "INSERT INTO test.docs (doc_type, doc_body, sender, recipient, file_name) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement prepared = connection.prepareStatement(query);
            prepared.setString(1, "xml");
            prepared.setString(2, decodedString);
            prepared.setString(3, String.valueOf(objectFromXML.head.getSender()));
            prepared.setString(4, String.valueOf(objectFromXML.head.getRecipient()));
            prepared.setString(5, String.valueOf(myFile.getFile_name()));
            prepared.execute();





while (resultSet.next()) {
                System.out.println(
                        resultSet.getRow() +
                        resultSet.getInt("doc_body") +
                        resultSet.getString("sender") +
                        resultSet.getString("recipient"));
            }


            //statement.executeUpdate("INSERT INTO test.docs (doc_body, sender, recipient) VALUES (order, 'sender', 'recipient')");

 resultSet.moveToInsertRow();
            resultSet.updateString("doc_body", String.valueOf(order));
            resultSet.updateString("sender", String.valueOf(order.head));
            resultSet.insertRow();


resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("doc_body"));
            }


        }*/
    }
}
