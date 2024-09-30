package org.hagiakinh.core.collection.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaGenericsExample2 {

    public static void main(String[] args) {
        List<Car>        carList = new ArrayList<>();
        Set<Car>         carSet  = new HashSet<>();
        Map<String, Car> carMap  = new HashMap<>();

        for(Car car : carList) {

        }

        for(Car car: carSet) {

        }

        for(String key: carMap.keySet()){

        }

        for(Car car: carMap.values()) {

        }
    }







}
