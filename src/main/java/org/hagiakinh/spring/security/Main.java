package org.hagiakinh.spring.security;

import org.hagiakinh.spring.security.handler.AuthenticationHandler;
import org.hagiakinh.spring.security.handler.AuthorizationHandler;
import org.hagiakinh.spring.security.handler.CorsHandler;
import org.hagiakinh.spring.security.handler.JwtAuthenticationHandler;
import org.hagiakinh.spring.security.model.Request;
import org.hagiakinh.spring.security.model.Response;
import org.hagiakinh.spring.security.service.JwtService;

public class Main {

    public static void main(String[] args) {
        // Initialize services
        JwtService jwtService = new JwtService();

        // Build chain of handlers
        AuthenticationHandler corsHandler = new CorsHandler();
        AuthenticationHandler jwtHandler = new JwtAuthenticationHandler(jwtService);
        AuthenticationHandler authorizationHandler = new AuthorizationHandler();

        // Set up the chain
        corsHandler.setNextHandler(jwtHandler)
                .setNextHandler(authorizationHandler);

        // Create a sample request
        Request request = new Request("/protected-resource", "GET", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnaWFraW5oMDgyMyIsImlhdCI6MTcyOTc3NzEzNywiZXhwIjoxNzI5ODEzMTM3fQ.yMsT-Oj7WaUjr-Mb_neZutzEU8g7oDATrOoePOdHNXg", null);
        Response response = new Response(200, "OK");

        // Process the request through the chain
        corsHandler.handle(request, response);

        // Final response
        response.sendResponse();
    }
}
