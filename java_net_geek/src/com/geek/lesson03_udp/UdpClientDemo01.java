package com.geek.lesson03_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClientDemo01 {

    public static void main(String[] args) throws IOException {

        // 建立一个 Socket。
        DatagramSocket datagramSocket = new DatagramSocket();

        String msg = "你好。";

        // 发送给谁。
        InetAddress address = InetAddress.getByName("192.168.142.154");
        int port = 9090;

        // 建个包。
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, address, port);

        // 发送包。
        datagramSocket.send(datagramPacket);

        // 关闭。
        datagramSocket.close();
    }
}
