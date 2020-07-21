package com.geek.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSenderDemo01 {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(8888);

        // 准备数据。
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data = bufferedReader.readLine();
            byte[] bytes = data.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 6666));

            datagramSocket.send(datagramPacket);

            if ("bye".equals(data)) {
                break;
            }
        }

        bufferedReader.close();
        datagramSocket.close();
    }
}
