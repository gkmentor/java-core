package org.hagiakinh.spring.aop.spring.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.hagiakinh.spring.aop.spring.annotation.Limit;
import org.hagiakinh.spring.aop.spring.annotation.Transaction;

public class AopHandler implements InvocationHandler {

    private final Object target;
    private final Map<String, Integer> callCount = new HashMap<>();

    public AopHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Before Advice
        if (method.isAnnotationPresent(Transaction.class)) {
            beforeTransaction();
        }

        if (method.isAnnotationPresent(Limit.class)) {
            Limit limitAnnotation = method.getAnnotation(Limit.class);
            int limit = limitAnnotation.value();
            String methodName = method.getName();
            callCount.putIfAbsent(methodName, 0);
            if (callCount.get(methodName) >= limit) {
                System.out.println("Limit exceeded for method: " + methodName);
                return null;
            }
            callCount.put(methodName, callCount.get(methodName) + 1);
        }

        // Around Advice
        Object result = null;
        try {
            System.out.println("Around - Before method execution");
            result = method.invoke(target, args);
            System.out.println("Around - After method execution");
        } catch (Exception e) {
            System.out.println("Around - Exception caught");
            throw e;
        } finally {
            // After Advice
            if (method.isAnnotationPresent(Transaction.class)) {
                afterTransaction();
            }
        }
        return result;
    }

    private void beforeTransaction() {
        System.out.println("Before - Starting transaction...");
    }

    private void afterTransaction() {
        System.out.println("After - Committing transaction...");
    }

    // Create a proxy instance
    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new AopHandler(target));
    }
}
