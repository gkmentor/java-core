package org.hagiakinh.core.reflection.dynamic_proxy;

public class MyServiceImpl implements MyService {

    @Loggable(value = "Adding numbers")
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Loggable(value = "Subtracting numbers")
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public void print() {
        System.out.println("print call");
    }
}
