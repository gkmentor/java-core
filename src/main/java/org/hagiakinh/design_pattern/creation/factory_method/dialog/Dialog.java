package org.hagiakinh.design_pattern.creation.factory_method.dialog;

import org.hagiakinh.design_pattern.creation.factory_method.button.Button;

public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
