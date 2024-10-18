package org.hagiakinh.spring.aop.transaction.service;

public class BankServiceImpl implements BankService {

    public void transferMoney() throws Exception {
        System.out.println("Transferring money...");
        throw new Exception("An error occurred while transferring money.");
    }
}