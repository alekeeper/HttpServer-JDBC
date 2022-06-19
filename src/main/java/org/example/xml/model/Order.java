package org.example.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ORDER")
public class Order {

    @XStreamAlias("DOCUMENTNAME")
    private String documentName;

    @XStreamAlias("NUMBER")
    private String number;

    @XStreamAlias("DATE")
    private String date;

    @XStreamAlias("HEAD")
    public Head head = new Head();

    public Head getHead() {
        return head;
    }

    public String getDocumentName() {
        return documentName;
    }
    public String getNumber() {
        return number;
    }
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "org.example.xml.model.Order{" +
                "documentName='" + documentName + '\'' +
                ", number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", head=" + head +
                '}';
    }
}

