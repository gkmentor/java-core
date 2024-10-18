package org.hagiakinh.spring.aop.spring.service;

import org.hagiakinh.spring.aop.spring.annotation.Limit;
import org.hagiakinh.spring.aop.spring.annotation.Transaction;

public class MyServiceImpl implements MyService {

    @Transaction
    @Override
    public void performTransaction() {
        System.out.println("Executing transaction logic...");
    }

    @Limit(value = 3)
    @Override
    public void limitedOperation() {
        System.out.println("Executing limited operation...");
    }
}
