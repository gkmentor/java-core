package org.hagiakinh.core.reflection.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class AnnotationInvocationHandler implements InvocationHandler {
    private final Object target;

    public AnnotationInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("AnnotationInvocationHandler call");
        // Kiểm tra xem phương thức có annotation @Loggable hay không
        if (method.isAnnotationPresent(Loggable.class)) {
            // Lấy giá trị của annotation @Loggable
            Loggable loggable = method.getAnnotation(Loggable.class);
            System.out.println(loggable.value());  // Ghi log thông qua giá trị của annotation
        }

        // Gọi phương thức thực tế
        return method.invoke(target, args);
    }
}