package org.example.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javax.activation.MimetypesFileTypeMap;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class XmlUtils {

    public static String getDocumentExtension(String fileName) {

        List<String> list = new ArrayList<>();

        String[] parts = fileName.split("\\.");
        for(String part: parts){
            list.add(part);
        }

        return list.get(1);
    }

    /*public static String getRootElement(byte[] body) throws IOException {
        //String docType = URLConnection.guessContentTypeFromName(fileName);

        InputStream is = new BufferedInputStream(new ByteArrayInputStream(body));
        String mimeType = URLConnection.guessContentTypeFromStream(is);

        *//*FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String mimeType = fileNameMap.getContentTypeFor(fileName);

        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        String mimeType = mimeTypesMap.getContentType(fileName);*//*

        return mimeType;
    }*/

    public static <T> T xmlToObject(byte[] body, Class <T> clazz) throws ClassNotFoundException {

        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypes(new Class[]{clazz});
        xstream.processAnnotations(clazz);
        return (T) xstream.fromXML(new ByteArrayInputStream(body));
    }
}
