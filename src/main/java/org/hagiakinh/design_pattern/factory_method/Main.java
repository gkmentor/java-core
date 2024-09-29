package org.hagiakinh.design_pattern.factory_method;

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
