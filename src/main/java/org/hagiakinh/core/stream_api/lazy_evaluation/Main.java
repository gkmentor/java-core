package org.hagiakinh.core.stream_api.lazy_evaluation;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long count = numbers.stream()
                .filter(n -> {
                    System.out.println("Filter: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("Map: " + n);
                    return n * n;
                })
                .count(); // Thao tác kết thúc

        System.out.println("Total even numbers: " + count);
    }
}
