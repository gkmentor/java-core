package org.hagiakinh.core.io.concurrent_io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

public class FileReaderTask {

    private Path filePath;
    private ExecutorService executor;

    public FileReaderTask(String filePath, ExecutorService executor) {
        this.filePath = Paths.get(filePath);
        this.executor = executor;
    }

    public void readFile() {
        try {
            // Mở AsynchronousFileChannel với ExecutorService đã cung cấp
            AsynchronousFileChannel asyncFileChannel = AsynchronousFileChannel.open(
                    filePath,
                    Collections.singleton(StandardOpenOption.READ),
                    executor
            );

            // Tạo ByteBuffer để lưu dữ liệu đọc được
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Bắt đầu đọc từ vị trí 0
            asyncFileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    attachment.flip();
                    byte[] data = new byte[attachment.limit()];
                    attachment.get(data);
                    System.out.println("Đọc thành công file: " + filePath.getFileName());
                    System.out.println(new String(data));
                    try {
                        asyncFileChannel.close();
                    } catch (IOException e) {
                        System.err.println("Error closing file channel: " + e.getMessage());
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.err.println(
                            "Error đọc file " + filePath.getFileName() + ": " + exc.getMessage());
                    try {
                        asyncFileChannel.close();
                    } catch (IOException e) {
                        System.err.println("Error closing file channel: " + e.getMessage());
                    }
                }
            });

        } catch (IOException e) {
            System.err.println("Error mở file " + filePath.getFileName() + ": " + e.getMessage());
        }
    }
}

