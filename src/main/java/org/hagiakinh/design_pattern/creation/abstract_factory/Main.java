package org.hagiakinh.design_pattern.creation.abstract_factory;

public class Main {

    private static Application configureApplication() {
        return new Application(getFactory());
    }

    private static GUIFactory getFactory() {
        return switch (System.getProperty("os.name").toLowerCase()) {
            case "windows 11" -> new WindowsFactory();
            case "mac" -> new MacOSFactory();
            default -> throw new RuntimeException("Not found factory");
        };
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
