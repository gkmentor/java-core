package org.hagiakinh.core.stream_api.pipeline_processing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("stream", "api", "java", "parallel", "performance", "optimization");

        // Pipeline để lọc các từ có độ dài > 4, chuyển đổi chúng thành chữ hoa và sắp xếp
        List<String> result = words.stream()
                .filter(word -> word.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);


        List<String> result2 = new ArrayList<>();
        for (String word : words) {
            if (word.length() > 4) {
                result2.add(word.toUpperCase());
            }
        }
        Collections.sort(result2);
        System.out.println(result2);
    }
}
