package org.hagiakinh.core.io.concurrent_io.nio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentNIOReader {

    public static void main(String[] args) {
        // Danh sách các tệp tin cần đọc
        String[] filePaths = {
                "file1.txt",
                "file2.txt",
                "file3.txt",
                "file4.txt",
                "file5.txt"
        };

        // Tạo một Thread Pool với 4 Threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Tạo và chạy các tác vụ đọc tệp tin
        for (String filePath : filePaths) {
            FileReaderTask task = new FileReaderTask(
                    "src/main/resources/concurrent_io/thread/" + filePath, executor);
            task.readFile();
        }

        // Đóng Executor sau khi hoàn thành tất cả các tác vụ
        executor.shutdown();
        try {
            // Đợi cho đến khi tất cả các tác vụ hoàn thành hoặc timeout sau 1 giờ
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            e.printStackTrace();
        }

        System.out.println("Tất cả các tệp tin đã được đọc.");
    }
}
