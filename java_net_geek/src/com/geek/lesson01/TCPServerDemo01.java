package com.geek.lesson01;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo01 {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteOutputStream byteOutputStream = null;
        try {
            // 我得有以个地址。
            serverSocket = new ServerSocket(9999);
            // 等待客户端连接。
            socket = serverSocket.accept();
            // 读取客户端消息。
            inputStream = socket.getInputStream();

            // ~ ~ ~
//            byte[] bytes = new byte[1024];
//            int length;
//            while ((length = inputStream.read(bytes)) != -1) {
//                String msg = new String(bytes, 0, length);
//                System.out.println(msg);
//            }
            // ~ ~ ~

            // 管道流。
            byteOutputStream = new ByteOutputStream();
            byte[] bytes = new byte[1024];
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                byteOutputStream.write(bytes, 0, length);
            }
            System.out.println(byteOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteOutputStream != null) {
                byteOutputStream.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
