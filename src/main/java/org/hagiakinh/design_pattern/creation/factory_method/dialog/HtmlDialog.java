package org.hagiakinh.design_pattern.creation.factory_method.dialog;

import org.hagiakinh.design_pattern.creation.factory_method.button.Button;
import org.hagiakinh.design_pattern.creation.factory_method.button.HtmlButton;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
