package com.geek.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceiver implements Runnable {

    private DatagramSocket datagramSocket = null;
    private int port;
    private String msgFrom;

    public TalkReceiver(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            byte[] container = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
            try {
                datagramSocket.receive(datagramPacket);// 阻塞式接受包裹。
            } catch (IOException e) {
                e.printStackTrace();
            }

            // bye ~ 断开连接。
            byte[] data = datagramPacket.getData();
            String receiveData = new String(data, 0, data.length);

            System.out.println(msgFrom + "：" + receiveData);

            if ("bye".equals(receiveData)) {
                break;
            }
        }

        datagramSocket.close();
    }
}
