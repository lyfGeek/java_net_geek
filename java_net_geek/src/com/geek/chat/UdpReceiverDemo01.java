package com.geek.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiverDemo01 {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(6666);

        while (true) {
            byte[] container = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
            datagramSocket.receive(datagramPacket);// 阻塞式接受包裹。

            // bye ~ 断开连接。
            byte[] data = datagramPacket.getData();
            String receiveData = new String(data, 0, data.length);

            System.out.println(receiveData);

            if ("bye".equals(receiveData)) {
                break;
            }
        }

        datagramSocket.close();
    }
}
