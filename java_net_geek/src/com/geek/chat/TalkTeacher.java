package com.geek.chat;

public class TalkTeacher {

    public static void main(String[] args) {
        // 开启两个线程。
        new Thread(new TalkSend(5555, "localhost", 8888)).start();
        new Thread(new TalkReceiver(9999, "学生")).start();
    }
}
