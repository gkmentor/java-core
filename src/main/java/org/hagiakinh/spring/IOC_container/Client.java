package org.hagiakinh.spring.IOC_container;

import org.hagiakinh.spring.IOC_container.service.Service;

public class Client {
    private final Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void doSomething() {
        service.serve();
    }
}
