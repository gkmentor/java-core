package org.hagiakinh.design_pattern.creation.abstract_factory_chair.chair;

public class VictorianChair implements Chair {

    @Override
    public void sitOn() {
        System.out.println("Victorian chair sit on");
    }
}
