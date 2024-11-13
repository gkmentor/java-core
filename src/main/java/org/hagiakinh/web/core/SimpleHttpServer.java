package org.hagiakinh.web.core;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.hagiakinh.web.core.dispatcher.Dispatcher;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException, IOException {
        Dispatcher dispatcher = new Dispatcher();

        // Tạo server tại cổng 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", (HttpExchange exchange) -> {
            String path = exchange.getRequestURI().getPath();
            String response = dispatcher.dispatch(path);

            // Gửi phản hồi về client
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        // Bắt đầu server
        server.setExecutor(null); // Tạo một executor mặc định
        server.start();
        System.out.println("Server started at http://localhost:8080");
    }
}
