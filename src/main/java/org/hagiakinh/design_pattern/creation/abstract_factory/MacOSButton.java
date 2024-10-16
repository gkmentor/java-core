package org.hagiakinh.design_pattern.creation.abstract_factory;

public class MacOSButton implements Button{

    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
