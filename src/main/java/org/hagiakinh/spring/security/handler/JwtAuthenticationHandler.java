package org.hagiakinh.spring.security.handler;

import org.hagiakinh.spring.security.model.Request;
import org.hagiakinh.spring.security.model.Response;
import org.hagiakinh.spring.security.service.JwtService;

public class JwtAuthenticationHandler  extends AuthenticationHandler {

    private final JwtService jwtService;

    public JwtAuthenticationHandler(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected boolean doHandle(Request request, Response response) {
        String authorizationHeader = request.getAuthorizationHeader();

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            response = new Response(401, "Unauthorized: Missing or invalid Authorization header");
            response.sendResponse();
            return false; // Stop chain
        }

        String token = authorizationHeader.substring(7);
        if (!jwtService.isValidToken(token)) {
            response = new Response(403, "Forbidden: Invalid token");
            response.sendResponse();
            return false; // Stop chain
        }

        System.out.println("Authenticated user: " + jwtService.getUsernameFromToken(token));
        return true; // Continue to next handler
    }
}
