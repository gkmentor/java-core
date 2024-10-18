package org.hagiakinh.spring.aop.spring;

import org.hagiakinh.spring.aop.spring.handler.AopHandler;
import org.hagiakinh.spring.aop.spring.service.MyService;
import org.hagiakinh.spring.aop.spring.service.MyServiceImpl;

public class Main {

    public static void main(String[] args) {
        MyService myService = new MyServiceImpl();
        MyService proxyService = (MyService) AopHandler.createProxy(myService);

        // Test transaction handling
        proxyService.performTransaction();
        proxyService.performTransaction();

        // Test limit handling
        for (int i = 0; i < 5; i++) {
            proxyService.limitedOperation();
        }
    }
}
