package org.hagiakinh.core.stream_api.optimized_internal_implementation;

import java.util.List;
import java.util.stream.LongStream;

public class ParallelStream {
    public static void main(String[] args) {
        List<Long> largeList = LongStream.rangeClosed(1, 100_000_000)
                .boxed()
                .toList();

        long startTime = System.currentTimeMillis();

        long count = largeList.stream()
                .filter(n -> n % 2 == 0)
                .count();

        long sequentialTime = System.currentTimeMillis() - startTime;
        System.out.println("Sequential Count: " + count + " in " + sequentialTime + " ms");

        startTime = System.currentTimeMillis();

        long parallelCount = largeList.parallelStream()
                .peek(n -> {
                    // In ra tên thread đang thực thi
                    // Chú ý: Đối với tập dữ liệu lớn, sẽ tạo ra rất nhiều log. Đây chỉ là ví dụ minh họa.
                    if (n % 10_000_000 == 0) { // Giới hạn số lần in để tránh log quá nhiều
                        System.out.println("Processing " + n + " on thread " + Thread.currentThread().getName());
                    }
                })
                .filter(n -> n % 2 == 0)
                .count();

        long parallelTime = System.currentTimeMillis() - startTime;
        System.out.println("Parallel Count: " + parallelCount + " in " + parallelTime + " ms");
    }
}
