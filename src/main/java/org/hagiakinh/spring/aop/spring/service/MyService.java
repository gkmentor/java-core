package org.hagiakinh.spring.aop.spring.service;

import org.hagiakinh.spring.aop.spring.annotation.Limit;
import org.hagiakinh.spring.aop.spring.annotation.Transaction;

public interface MyService {

    @Transaction
    void performTransaction();

    @Limit(value = 3)
    void limitedOperation();
}
