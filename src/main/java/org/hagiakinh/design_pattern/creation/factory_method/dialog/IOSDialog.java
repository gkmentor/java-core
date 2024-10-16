package org.hagiakinh.design_pattern.creation.factory_method.dialog;

import org.hagiakinh.design_pattern.creation.factory_method.button.Button;
import org.hagiakinh.design_pattern.creation.factory_method.button.IOSButton;

public class IOSDialog extends Dialog {

    @Override
    public Button createButton() {
        return new IOSButton();
    }
}
