package org.hagiakinh.web.core.model;

public class Response {
    private final StringBuilder content = new StringBuilder();

    public void write(String data) {
        content.append(data);
    }

    public String getContent() {
        return content.toString();
    }
}
