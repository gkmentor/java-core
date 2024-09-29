package org.hagiakinh.core.collection.equals_hashcode;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("A", 1);
        Animal animal2 = new Animal("A", 1);
        System.out.println(animal1.equals(animal2));

        System.out.println(animal1.hashCode());
        System.out.println(animal2.hashCode());
        Integer a = 6;
        Integer b = 6;
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        Map<Integer, Animal> map = new HashMap<>();
        map.put(a, animal1);

        String abc1 = "abc";
        String abc2 = new String("abc");
        System.out.println(abc1.equals(abc2));
        System.out.println(abc1 == abc2);
    }
}
