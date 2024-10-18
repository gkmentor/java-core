package org.hagiakinh.spring.aop.transaction.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler trong Java là một interface thuộc gói java.lang.reflect, được sử dụng để định
 * nghĩa các hành vi của proxy khi một phương thức được gọi trên proxy đó. Nó cho phép bạn can thiệp
 * và kiểm soát cách các phương thức của một đối tượng proxy được thực thi.
 **/

public class TransactionAspect implements InvocationHandler {

    private final Object target;
    private final TransactionManager transactionManager;

    public TransactionAspect(Object target, TransactionManager transactionManager) {
        this.target = target;
        this.transactionManager = transactionManager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            transactionManager.beginTransaction();
            result = method.invoke(target, args);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            System.out.println("Exception: " + e.getMessage());
        }
        return result;
    }
}
