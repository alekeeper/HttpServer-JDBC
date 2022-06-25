package org.example.utils;

import com.thoughtworks.xstream.XStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.example.xml.model.IDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XmlUtils {

    public static String getRootElement(byte[] body) throws IOException, SAXException, ParserConfigurationException {

        InputStream is = new ByteArrayInputStream(body);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();

        Document doc = builder.parse(is);
        Node node = doc.getDocumentElement();
        String rootElement = node.getNodeName();
        is.close();

        return rootElement;
    }

    public static IDocument xmlToObject(byte[] body, Class<?> clazz) {

        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypes(new Class[]{clazz});
        xstream.processAnnotations(clazz);

        return (IDocument) xstream.fromXML(new ByteArrayInputStream(body));
    }
}
