package org.hagiakinh.core.io.networking.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            byte[] buffer = new byte[1024];

            Scanner scanner = new Scanner(System.in);
            System.out.println("Type your message:");

            while (true) {
                // Đọc dữ liệu từ bàn phím
                String message = scanner.nextLine();
                byte[] messageBytes = message.getBytes();

                // Gửi dữ liệu tới server
                DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, address, 12345);
                socket.send(packet);

                // Nhận phản hồi từ server
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);
                String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println("Response from server: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
