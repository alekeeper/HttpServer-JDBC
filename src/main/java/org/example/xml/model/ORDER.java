package org.example.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ORDER")
public class ORDER implements IDocument {

    @XStreamAlias("DOCUMENTNAME")
    private String documentName;

    @XStreamAlias("NUMBER")
    private String number;

    @XStreamAlias("DATE")
    private String date;

    @XStreamAlias("HEAD")
    private Head head;

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
    public String getSender() {
        return head.getSender();
    }

    @Override
    public String getRecipient() {
        return head.getRecipient();
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

