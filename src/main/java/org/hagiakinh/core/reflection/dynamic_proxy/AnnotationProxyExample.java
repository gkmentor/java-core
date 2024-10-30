package org.hagiakinh.core.reflection.dynamic_proxy;

import java.lang.reflect.Proxy;

public class AnnotationProxyExample {
    public static void main(String[] args) {
        MyService myService = new MyServiceImpl();

        // Tạo proxy cho đối tượng MyService
        MyService proxyInstance = (MyService) Proxy.newProxyInstance(
                myService.getClass().getClassLoader(),
                new Class[]{MyService.class},
                new AnnotationInvocationHandler(myService)
        );

        // Gọi các phương thức trên proxy
        proxyInstance.add(5, 3);  // Sẽ ghi log với giá trị từ annotation
        proxyInstance.print();
    }
}