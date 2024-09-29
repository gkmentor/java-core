package org.hagiakinh.design_pattern.factory_method;

public abstract class Dialog {


    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
