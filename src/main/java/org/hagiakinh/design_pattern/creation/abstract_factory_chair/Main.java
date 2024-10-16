package org.hagiakinh.design_pattern.creation.abstract_factory_chair;

import org.hagiakinh.design_pattern.creation.abstract_factory_chair.factory.ArtFactory;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.factory.FurnitureFactory;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.factory.ModernFactory;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.factory.VictorianFactory;

public class Main {

    public static void main(String[] args) {
        FurnitureFactory factory = getFactory("modern");
        factory.createChair();
        factory.createTable();
    }

    private static FurnitureFactory getFactory(String factory) {
        return switch (factory) {
            case "modern" -> new ModernFactory();
            case "victorian" -> new VictorianFactory();
            case "art" -> new ArtFactory();
            default -> throw new RuntimeException("Not found factory");
        };
    }
}
