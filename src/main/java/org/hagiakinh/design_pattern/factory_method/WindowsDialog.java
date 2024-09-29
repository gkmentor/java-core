package org.hagiakinh.design_pattern.factory_method;

public class WindowsDialog extends Dialog{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
