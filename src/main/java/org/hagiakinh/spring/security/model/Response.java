package org.hagiakinh.spring.security.model;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private int statusCode;
    private String message;
    private Map<String, String> headers;

    public Response(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public void setHeader(String key, String value) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        headers.put(key, value);
    }

    public void sendResponse() {
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Message: " + message);
        System.out.println("Headers: " + headers);
    }
}
