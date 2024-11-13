package org.hagiakinh.web.core;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.hagiakinh.web.core.dispatcher.Dispatcher;
import org.hagiakinh.web.core.model.Request;
import org.hagiakinh.web.core.model.Response;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException, IOException {
        Dispatcher dispatcher = new Dispatcher();

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", (exchange) -> {
            String path = exchange.getRequestURI().getPath();
            Request request = new Request(path);

            // Xử lý yêu cầu thông qua dispatcher
            String result = dispatcher.dispatch(request);
            exchange.sendResponseHeaders(200, result.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(result.getBytes());
            os.close();
        });

        // Bắt đầu server
        server.start();
        System.out.println("Server started at http://localhost:8080");
    }
}
