package com.geek.lesson03_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerDemo01 {

    public static void main(String[] args) throws IOException {

        // 开放端口。
        DatagramSocket datagramSocket = new DatagramSocket(9090);

        // 接收数据包。
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);

        // 接收。
        datagramSocket.receive(datagramPacket);

        System.out.println(datagramPacket.getAddress());
        System.out.println(datagramPacket.getData());
        System.out.println(datagramPacket.getLength());
        System.out.println(datagramPacket.getOffset());
        System.out.println(datagramPacket.getPort());
        System.out.println(datagramPacket.getSocketAddress());

        // 关闭连接。
        datagramSocket.close();
    }
}
