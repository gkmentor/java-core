package org.hagiakinh.design_pattern.abstract_factory;

public class WindowsButton implements Button{

    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
