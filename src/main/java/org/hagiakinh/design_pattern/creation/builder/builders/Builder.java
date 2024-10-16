package org.hagiakinh.design_pattern.creation.builder.builders;

import org.hagiakinh.design_pattern.creation.builder.components.Engine;
import org.hagiakinh.design_pattern.creation.builder.components.GPSNavigator;
import org.hagiakinh.design_pattern.creation.builder.components.Transmission;
import org.hagiakinh.design_pattern.creation.builder.components.TripComputer;
import org.hagiakinh.design_pattern.creation.builder.cars.CarType;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
