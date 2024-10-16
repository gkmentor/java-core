package org.hagiakinh.design_pattern.creation.abstract_factory;

public class WindowsCheckbox implements Checkbox{

    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}
