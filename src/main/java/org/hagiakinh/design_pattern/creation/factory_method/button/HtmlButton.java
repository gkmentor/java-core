package org.hagiakinh.design_pattern.creation.factory_method.button;

public class HtmlButton implements Button {

    @Override
    public void render() {
        System.out.println("Render HTML Button");
    }

    @Override
    public void onClick() {
        System.out.println("Click HTML Button");
    }
}
