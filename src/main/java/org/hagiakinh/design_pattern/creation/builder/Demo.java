package org.hagiakinh.design_pattern.creation.builder;

import org.hagiakinh.design_pattern.creation.builder.cars.Car;
import org.hagiakinh.design_pattern.creation.builder.builders.CarBuilder;
import org.hagiakinh.design_pattern.creation.builder.builders.CarManualBuilder;
import org.hagiakinh.design_pattern.creation.builder.cars.Manual;
import org.hagiakinh.design_pattern.creation.builder.director.Director;

public class Demo {

    public static void main(String[] args) {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());



        Personal personal = Personal.builder()
                .name("Ha Gia Kinh")
                .age(18)
                .build();
    }

}
