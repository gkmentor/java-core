package org.hagiakinh.web.core.controller;

import org.hagiakinh.web.core.dispatcher.RequestHandler;

public class AboutHandler implements RequestHandler {
    @Override
    public String handle() {
        return "Welcome to the About Page!";
    }
}
