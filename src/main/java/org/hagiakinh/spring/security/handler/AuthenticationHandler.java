package org.hagiakinh.spring.security.handler;

import org.hagiakinh.spring.security.model.Request;
import org.hagiakinh.spring.security.model.Response;

public abstract class AuthenticationHandler {

    private AuthenticationHandler nextHandler;

    public AuthenticationHandler setNextHandler(AuthenticationHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handle(Request request, Response response) {
        if (doHandle(request, response) && nextHandler != null) {
            nextHandler.handle(request, response);
        }
    }

    protected abstract boolean doHandle(Request request, Response response);
}
