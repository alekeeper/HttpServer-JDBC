package org.example.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.ByteArrayInputStream;

public class XmlUtils {

    public static String getRootElement(byte[] body) {
        return "";
    }

    public static <T> T xmlToObject(byte[] body, Class <T> clazz) throws ClassNotFoundException {

        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypes(new Class[]{clazz});
        xstream.processAnnotations(clazz);
        return (T) xstream.fromXML(new ByteArrayInputStream(body));
    }
}
