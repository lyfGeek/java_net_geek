package com.geek.lesson01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo02 {

    public static void main(String[] args) throws IOException {

        // 创建服务。
        ServerSocket serverSocket = new ServerSocket(9000);
        // 监听客户端连接。
        Socket socket = serverSocket.accept();// 阻塞式监听。
        // 获取输入流。
        InputStream inputStream = socket.getInputStream();
        // 文件输出。
        FileOutputStream fileOutputStream = new FileOutputStream(new File("recieve.jpg"));
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, length);
        }

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
