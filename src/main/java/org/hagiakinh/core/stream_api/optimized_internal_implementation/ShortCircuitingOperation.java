package org.hagiakinh.core.stream_api.optimized_internal_implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ShortCircuitingOperation {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Tìm số chẵn đầu tiên lớn hơn 5
        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n > 5)
                .filter(n -> n % 2 == 0)
                .findFirst();

        firstEven.ifPresent(System.out::println); // Kết quả: 6
    }
}


