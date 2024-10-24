package org.hagiakinh.spring.security.handler;

import org.hagiakinh.spring.security.model.Request;
import org.hagiakinh.spring.security.model.Response;

public class AuthorizationHandler extends AuthenticationHandler {

    @Override
    protected boolean doHandle(Request request, Response response) {
        System.out.println("Authorization Handler: Checking user permissions");

        // Add logic to verify user roles or permissions
        if (!hasAccess(request)) {
            response = new Response(403, "Forbidden: User does not have access");
            response.sendResponse();
            return false; // Stop chain
        }

        return true; // Continue to next handler
    }

    private boolean hasAccess(Request request) {
        // Logic to check user's role or permission based on request path or method
        // In a real-world scenario, use role/permission checks
        return true;
    }
}
