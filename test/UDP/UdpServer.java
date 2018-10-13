/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月13日
 * @Description: 多次交流
 * 1、使用DatagramSocket 指定端口 创建接收端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagramPacket p)
 * 4、分析数据
 *      byte[] getData()
 *             getLength()
 * 5、释放资源
 */
package com.sethnie.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {

    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中...");
        // 1、使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(6666);
        // 2、准备容器 封装成DatagramPacket包裹

        while (true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            // 3、阻塞式接收包裹receive(DatagramPocket p)
            server.receive(packet);
            // 4、分析数据
            // byte[] getData()
            // getLength()
            byte[] datas = packet.getData();
            int len = packet.getLength();
            System.out.println(new String(datas, 0, len));

            if (datas.equals("bye")) {
                break;
            }
        }

        // 5、释放资源
        server.close();
        System.out.println("接收方接收完毕...");
    }

}
