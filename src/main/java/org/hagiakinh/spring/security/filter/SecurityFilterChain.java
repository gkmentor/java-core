package org.hagiakinh.spring.security.filter;

import org.hagiakinh.spring.security.handler.AuthenticationHandler;
import org.hagiakinh.spring.security.model.Request;
import org.hagiakinh.spring.security.model.Response;

public class SecurityFilterChain {

    private AuthenticationHandler firstHandler;

    public SecurityFilterChain(AuthenticationHandler firstHandler) {
        this.firstHandler = firstHandler;
    }

    public void doFilter(Request request, Response response) {
        firstHandler.handle(request, response);
    }
}
