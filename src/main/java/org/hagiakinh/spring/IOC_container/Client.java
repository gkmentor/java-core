package org.hagiakinh.spring.IOC_container;

import org.hagiakinh.spring.IOC_container.service.Service;

public class Client { // kết hợp cả 2 cái này gọi là Inversion Of Control (IOC)

    private final Service service; // đây là dependency inversion - SOLID

    public Client(Service service) {   // đây là dependency injection
        this.service = service;
    }

    public void doSomething() {
        service.serve();
    }
}
