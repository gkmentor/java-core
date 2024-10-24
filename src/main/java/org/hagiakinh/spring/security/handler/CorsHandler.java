package org.hagiakinh.spring.security.handler;

import org.hagiakinh.spring.security.model.Request;
import org.hagiakinh.spring.security.model.Response;

public class CorsHandler extends AuthenticationHandler {

    @Override
    protected boolean doHandle(Request request, Response response) {
        System.out.println("CORS Handler: Applying CORS headers");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers", "Accept, Content-Type, Authorization");
        return true;
    }
}