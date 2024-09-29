package org.hagiakinh.core.io.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true)) {

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                writer.println("Echo: " + clientMessage);
            }

        } catch (IOException ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

