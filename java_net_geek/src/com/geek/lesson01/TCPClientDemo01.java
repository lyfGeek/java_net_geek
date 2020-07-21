package com.geek.lesson01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientDemo01 {

    public static void main(String[] args) {

        Socket socket = null;
        OutputStream outputStream = null;

        try {
            // 要知道服务器的地址。
            InetAddress serverIP = InetAddress.getByName("192.168.142.154");
            // 端口号。
            int port = 9999;
            // 创建一个 Socket 连接。
            socket = new Socket(serverIP, port);
            // 发送消息。
            outputStream = socket.getOutputStream();
            outputStream.write("你好".getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
