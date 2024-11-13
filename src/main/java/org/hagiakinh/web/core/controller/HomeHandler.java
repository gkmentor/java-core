package org.hagiakinh.web.core.controller;

import org.hagiakinh.web.core.dispatcher.RequestHandler;

public class HomeHandler implements RequestHandler {
    @Override
    public String handle() {
        return "Welcome to the Home Page!";
    }
}
