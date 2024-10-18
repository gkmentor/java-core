package org.hagiakinh.spring.aop.transaction;

import java.lang.reflect.Proxy;
import org.hagiakinh.spring.aop.transaction.aspect.TransactionAspect;
import org.hagiakinh.spring.aop.transaction.aspect.TransactionManager;
import org.hagiakinh.spring.aop.transaction.service.BankService;
import org.hagiakinh.spring.aop.transaction.service.BankServiceImpl;

public class AOPTransactionDemo {
    public static void main(String[] args) {
        TransactionManager transactionManager = new TransactionManager();
        BankService bankService = new BankServiceImpl();

        BankService proxyService = (BankService) Proxy.newProxyInstance(
                BankService.class.getClassLoader(),
                new Class[]{BankService.class},
                new TransactionAspect(bankService, transactionManager)
        );

        try {
            proxyService.transferMoney();
        } catch (Exception e) {
            System.out.println("Error occurred in main: " + e.getMessage());
        }
    }
}
