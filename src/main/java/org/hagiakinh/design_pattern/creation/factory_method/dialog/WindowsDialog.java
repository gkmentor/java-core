package org.hagiakinh.design_pattern.creation.factory_method.dialog;

import org.hagiakinh.design_pattern.creation.factory_method.button.Button;
import org.hagiakinh.design_pattern.creation.factory_method.button.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
