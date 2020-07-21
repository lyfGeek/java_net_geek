package com.geek.lesson01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientDemo02 {

    public static void main(String[] args) throws IOException {

        Socket socket = null;
        OutputStream outputStream = null;

        // 要知道服务器的地址。
        InetAddress serverIP = InetAddress.getByName("192.168.142.154");
        // 端口号。
        int port = 9999;
        // 创建一个 Socket 连接。
        socket = new Socket(serverIP, port);

        // 创建一个输出流。
        outputStream = socket.getOutputStream();
        // 读取文件。
        FileInputStream fileInputStream = new FileInputStream(new File("G:\\lyfGeek\\IdeaProjects\\java_net_geek\\java_net_geek\\0.jpg"));
        // 写出文件。
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
        }

        socket.shutdownOutput();// 我已经传输完了。

        outputStream.close();
        socket.close();
    }
}
