package org.hagiakinh.core.reflection.dynamic_proxy;

public interface MyService {

    @Loggable(value = "Adding numbers")
    int add(int a, int b);

    @Loggable(value = "Subtracting numbers")
    int subtract(int a, int b);

    void print();
}
