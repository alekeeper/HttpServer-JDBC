package org.example.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Head {

    @XStreamAlias("SENDER")
    private String sender;
    @XStreamAlias("RECIPIENT")
    private String recipient;


    public String getSender() {
        return sender;
    }
    public String getRecipient() {
        return recipient;
    }

    @Override
    public String toString() {
        return "org.example.xml.model.Head{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}
