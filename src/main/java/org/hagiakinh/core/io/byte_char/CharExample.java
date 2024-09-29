package org.hagiakinh.core.io.byte_char;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/main/resources/input.txt"); // mở file văn bản
            FileWriter writer = new FileWriter("src/main/resources/output.txt"); // tạo file sao chép
            char[] buffer = new char[1024]; // tạo buffer để lưu ký tự từ file
            int charsRead;

            while ((charsRead = reader.read(buffer)) != -1) { // đọc ký tự từ file
                writer.write(buffer, 0, charsRead); // ghi ký tự vào file mới
            }

            reader.close();
            writer.close();
            System.out.println("File copied!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
