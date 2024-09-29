package org.hagiakinh.core.annotation.elements;

@interface Entity {
    String value() default "";
    String tableName() default "";
    String primaryKey() default "id";
}

@Entity(tableName = "vehicles", primaryKey = "vehicleId")
class Vehicle {
    private String vehicleId;
    private String model;
}

@Entity("horizontal")
class Horizontal {
    private String id;
    private String model;
}

public class Main {
}



