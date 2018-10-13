/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月13日
 * @Description: 
 * 文件下载：接收端
 * 1、使用DatagramSocket 指定端口 创建接收端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagramPacket p)
 * 4、分析数据 将字节数组还原为对应类型
 *      
 * 5、释放资源
 */
package com.sethnie.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

import com.sethnie.udp.Employee;

public class UdpFileServer {

    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中...");
        // 1、使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(6666);
        // 2、准备容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        // 3、阻塞式接收包裹receive(DatagramPocket p)
        server.receive(packet);
        // 4、分析数据
        //      byte[] getData()
        //             getLength()
        byte[] datas = packet.getData();
        int len = packet.getLength();
        
        System.out.println("数据长度--》"+datas.length+"-------------");
        //读取-->反序列化
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出顺序一致
        String msg= dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        Object str1 = dis.readObject();
        Object str2 = dis.readObject();
        Object str3 = dis.readObject();
        
        System.out.println(msg);
        System.out.println("-------------------");
        if(str1 instanceof String) {
            String strObj = (String)str1;
            System.out.println(strObj);
        }
        
        if(str2 instanceof Date) {
            Date strObj = (Date)str2;
            System.out.println(strObj);
        }
        
        if(str3 instanceof Employee) {
            Employee emp = (Employee)str3;
            System.out.println(emp.getName()+"---"+emp.getSalary());
        }
        
        
        
        // 5、释放资源
        server.close();
        System.out.println("接收完成...");
    }

}
