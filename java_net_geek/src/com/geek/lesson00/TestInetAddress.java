package com.geek.lesson00;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {

    public static void main(String[] args) {
//        new InetAddress()
        // 'InetAddress()' is not public in 'java.net.InetAddress'. Cannot be accessed from outside package
        try {
//            InetAddress localHost = InetAddress.getLocalHost();
//            System.out.println("localHost = " + localHost);
//            localHost = LAPTOP-0GJSKR6T/192.168.142.1

            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println("inetAddress1 = " + inetAddress1);
            // inetAddress1 = /127.0.0.1

            // 查询网站地址。
            InetAddress inetAddress2 = InetAddress.getByName("baidu.com");
            System.out.println("inetAddress2 = " + inetAddress2);
            // inetAddress2 = baidu.com/39.156.69.79

            InetAddress inetAddress3 = InetAddress.getByName("www.baidu.com");
            System.out.println("inetAddress3 = " + inetAddress3);
            // inetAddress3 = www.baidu.com/112.80.248.76

            // 常用方法。
            System.out.println(inetAddress1.getAddress());// [B@1b6d3586
            System.out.println(inetAddress1.getCanonicalHostName());// 127.0.0.1
            System.out.println(inetAddress1.getHostAddress());// 127.0.0.1
            System.out.println(inetAddress1.getHostName());// 127.0.0.1

            System.out.println(inetAddress2.getAddress());// [B@4554617c
            System.out.println(inetAddress2.getCanonicalHostName());// 39.156.69.79
            System.out.println(inetAddress2.getHostAddress());// 39.156.69.79
            System.out.println(inetAddress2.getHostName());// baidu.com

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
