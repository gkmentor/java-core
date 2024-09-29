package org.hagiakinh.core.io.concurrent_io.threads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTask implements Runnable {
    private String filePath;

    public FileReaderTask(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " đang đọc file: " + filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Xử lý nội dung dòng đọc được (ở đây chỉ in ra)
                System.out.println("[" + Thread.currentThread().getName() + "] " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file " + filePath + ": " + e.getMessage());
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " đã hoàn thành đọc file: " + filePath);
    }
}
