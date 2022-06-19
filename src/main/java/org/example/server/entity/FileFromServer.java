package org.example.server.entity;

public class FileFromServer {

    private String file_name;
    private String body;

    public FileFromServer(String file_name, String body) {
        this.file_name = file_name;
        this.body = body;
    }

    public FileFromServer() {
    }

    public String getFileName() {
        return file_name;
    }

    public void setFileName(String file_name) {
        this.file_name = file_name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "name='" + file_name + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
