package org.hagiakinh.design_pattern.creation.abstract_factory_chair.table;

public class ModernTable implements Table {

    @Override
    public void putOn() {
        System.out.println("Modern table put on");
    }
}
