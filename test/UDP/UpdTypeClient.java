/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月13日
 * @Description: 
 * 基本类型：发送端
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、将基本数据转成字节数组
 * 3、封装成DatagramPacket 包裹，需要指定目的地
 * 4、发送包裹send(DatagramPacket p)
 * 5、释放资源
 */
package com.sethnie.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UpdTypeClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中...");
        // 1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client= new DatagramSocket(8888);
        // 2、准备数据 一定转成字节数组
        //写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("编码123测试");
        dos.writeInt(19);
        dos.writeBoolean(true);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();
        
        // 3、封装成DatagramPacket 包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",6666));
        // 4、发送包裹send(DatagramPacket p)
        client.send(packet);
        // 5、释放资源
        client.close();
        
        System.out.println("发送完成...");
        
        
    }
}
