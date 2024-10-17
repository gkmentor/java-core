package org.hagiakinh.spring.IOC_container.service;

public class SmsService implements Service {
    @Override
    public void serve() {
        System.out.println("Gửi sms...");
    }
}