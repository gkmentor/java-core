package org.hagiakinh.core.instanceof_operator;

class Animal {}
class Dog extends Animal {}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Animal dog2 = new Dog();

        // Kiểm tra đối tượng dog có phải là thể hiện của Dog không
        System.out.println(dog instanceof Dog);    // Kết quả: true

        // Kiểm tra đối tượng dog có phải là thể hiện của Animal không
        System.out.println(dog instanceof Animal); // Kết quả: true (vì Dog là lớp con của Animal)

        // Kiểm tra đối tượng animal có phải là thể hiện của Dog không
        System.out.println(animal instanceof Dog); // Kết quả: false

        // Kiểm tra với đối tượng null
        System.out.println(animal instanceof Dog); // Kết quả: false

        // Kiểm tra với đối tượng dog2 có phải là Dog không
        System.out.println(dog2 instanceof Dog); // Kết quả: true

        // Kiểm tra với đối tượng dog2 có phải là Animal không
        System.out.println(dog2 instanceof Animal); // Kết quả: true
    }
}



