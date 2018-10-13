/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月13日
 * @Description: 
 * 加入多线程，实现双向交流
 */
package com.sethnie.udp;

public class TalkTeacher {

    public static void main(String[] args) {
        new Thread(new TalkReceive(9999,"teacher")).start();//接收
        new Thread(new TalkSend(5555,"localhost",8888)).start();//发送
    }

}
