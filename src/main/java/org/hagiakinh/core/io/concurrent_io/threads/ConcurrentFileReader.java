package org.hagiakinh.core.io.concurrent_io.threads;

public class ConcurrentFileReader {
    public static void main(String[] args) {
        // Danh sách các tệp tin cần đọc
        String[] filePaths = {
                "file1.txt",
                "file2.txt",
                "file3.txt",
                "file4.txt",
                "file5.txt",
                "file6.txt",
                "file7.txt"
        };

        for (String filePath : filePaths) {
            FileReaderTask task = new FileReaderTask("src/main/resources/concurrent_io/thread/" + filePath);
            Thread thread = new Thread(task);
            thread.start();
        }

        System.out.println("Đã khởi chạy tất cả các Threads để đọc tệp tin.");
    }
}


