package org.hagiakinh.spring.IOC_container.service;

public class PushNotificationService implements Service {
    @Override
    public void serve() {
        System.out.println("Gửi thông báo đẩy...");
    }
}
