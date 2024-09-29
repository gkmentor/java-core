package org.hagiakinh.design_pattern.factory_method;

public class IOSDialog extends Dialog{

    @Override
    public Button createButton() {
        return new IOSButton();
    }
}
