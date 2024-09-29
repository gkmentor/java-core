package org.hagiakinh.design_pattern.factory_method;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
