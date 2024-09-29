package org.hagiakinh.core.reflection.dynamic_proxy;

public class MyServiceImpl implements MyService {

    @Loggable(value = "Adding numbers")
    @Override
    public int add(int a, int b) {
        System.out.println("add call");
        return a + b;
    }

    @Loggable(value = "Subtracting numbers")
    @Override
    public int subtract(int a, int b) {
        System.out.println("subtract call");
        return a - b;
    }

    @Override
    public void print() {
        System.out.println("print call");
    }
}
