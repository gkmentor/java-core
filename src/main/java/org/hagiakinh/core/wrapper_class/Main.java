package org.hagiakinh.core.wrapper_class;

public class Main {

    public static void main(String[] args) {
        // Tạo một đối tượng của lớp Integer để bọc giá trị int
        int primitiveInt = 5;  // biến nguyên thủy
        Integer wrappedInt = Integer.valueOf(primitiveInt); // bọc kiểu int thành lớp Integer

        // Tự động autoboxing (autoboxing)
        Integer autoBoxedInt = primitiveInt; // autoboxing tự động chuyển int sang Integer

        // Sử dụng phương thức của lớp Integer
        int parsedInt = Integer.parseInt("100");  // Chuyển chuỗi thành kiểu int

        // In ra giá trị
        System.out.println("Giá trị nguyên thủy: " + primitiveInt);
        System.out.println("Giá trị autoboxing: " + wrappedInt);
        System.out.println("Giá trị tự động autoboxing: " + autoBoxedInt);
        System.out.println("Giá trị sau khi parse: " + parsedInt);

        // unboxing
        int unboxedInt = wrappedInt; // unboxing tự động chuyển Integer về int
        System.out.println("Giá trị sau khi unboxing: " + unboxedInt);
    }
}





