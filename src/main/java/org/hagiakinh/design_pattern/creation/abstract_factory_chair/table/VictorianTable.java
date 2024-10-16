package org.hagiakinh.design_pattern.creation.abstract_factory_chair.table;

public class VictorianTable implements Table {

    @Override
    public void putOn() {
        System.out.println("Victorian table put on");
    }
}
