package org.hagiakinh.design_pattern.creation.factory_method;

import org.hagiakinh.design_pattern.creation.factory_method.dialog.Dialog;
import org.hagiakinh.design_pattern.creation.factory_method.dialog.HtmlDialog;
import org.hagiakinh.design_pattern.creation.factory_method.dialog.IOSDialog;
import org.hagiakinh.design_pattern.creation.factory_method.dialog.WindowsDialog;

public class Main {

    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        switch (System.getProperty("os.name")) {
            case "Windows 11":
                dialog = new WindowsDialog();
                break;
            case "HTML":
                dialog = new HtmlDialog();
                break;
            case "IOS":
                dialog = new IOSDialog();
                break;
            default:
                throw new RuntimeException("Not found dialog");
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
