/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月13日
 * @Description: 接收端
 */
package com.sethnie.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
    // 1、使用DatagramSocket 指定端口 创建接收端
    private DatagramSocket server;
    private String from;
    public TalkReceive(int port,String from) {
        this.from = from;
        System.out.println("-----接收方开始接收----");
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            // 3、阻塞式接收包裹receive(DatagramPocket p)
            try {
                server.receive(packet);
                byte[] datas = packet.getData();
                int len = packet.getLength();
                System.out.println(from+":"+new String(datas, 0, len));

                if (datas.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }

        // 5、释放资源
        server.close();
        System.out.println("-----接收方停止接收----");

    }

}
