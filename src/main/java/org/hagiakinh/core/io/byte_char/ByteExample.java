package org.hagiakinh.core.io.byte_char;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteExample {

    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("src/main/resources/image.jpg"); // mở file ảnh
            FileOutputStream out = new FileOutputStream("src/main/resources/copy_image.jpg"); // tạo file sao chép
            byte[] buffer = new byte[1024]; // tạo buffer để lưu byte từ file
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) { // đọc byte từ file
                out.write(buffer, 0, bytesRead); // ghi byte vào file mới
            }

            in.close();
            out.close();
            System.out.println("File copied!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


