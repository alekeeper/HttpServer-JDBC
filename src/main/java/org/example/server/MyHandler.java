package org.example.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.server.entity.FileFromServer;
import org.example.storages.IDocumentStorage;
import org.example.utils.JsonUtils;
import org.example.utils.XmlUtils;
import org.example.xml.model.Order;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class MyHandler implements HttpHandler {

    /*private static final Map <String, Class> ALLOW_TYPES = new HashMap<>(){
        {
            put("ORDER", Order.class);
        }
    };*/

    private IDocumentStorage storage;

    public MyHandler(IDocumentStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        //считывание post запроса в байты
        InputStream inputStream = exchange.getRequestBody();
        System.out.println("inputStream: " + inputStream);
        String jsonBody = null;
        try {
            //преобразование из байтов в json
            jsonBody = new String(inputStream.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("jsonBody: " + jsonBody);

        try {
            //парсинг из json в объект
            FileFromServer fileFromServer = JsonUtils.parseFromJson(FileFromServer.class, jsonBody);
            System.out.println("fileFromServer: " + fileFromServer);
            System.out.println("fileFromServer.getFileName(): " + fileFromServer.getFileName());

            //расшифровка из base64
            byte[] body = Base64.getDecoder().decode(fileFromServer.getBody());
            System.out.println("body: " + body);

            //получение корневого элемента
            /*String docType = XmlUtils.getRootElement(body);
            System.out.println("docType: " + docType);*/

            //получение расширения файла
            String docType = XmlUtils.getDocumentExtension(fileFromServer.getFileName());

            //Class type = ALLOW_TYPES.get(docType);

            Order order = XmlUtils.xmlToObject(body, Order.class);
            System.out.println("order: " + order);

            storage.insert(docType, JsonUtils.parseToJson(order).getBytes(), order.getHead().getSender(), order.getHead().getRecipient(), fileFromServer.getFileName());
            System.out.println("inserted to storage");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String response = "200 OK";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
        System.out.println(response);

        /*byte[] bytes = fileFromServer.toString().getBytes();
        exchange.sendResponseHeaders(200, bytes.length);

        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(bytes);
        outputStream.close();*/
    }
}
