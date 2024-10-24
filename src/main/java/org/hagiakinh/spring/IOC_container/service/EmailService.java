package org.hagiakinh.spring.IOC_container.service;

public class EmailService implements Service {

    @Override
    public void serve() {
        System.out.println("Gửi email...");
    }
}