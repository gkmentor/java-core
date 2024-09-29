package org.hagiakinh.core.io.networking.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(12345);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Server is listening on port 12345");

            while (true) {
                // Nhận dữ liệu từ client
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);

                // Gửi phản hồi về client
                String response = "Server reply: " + received;
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length,
                        packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


