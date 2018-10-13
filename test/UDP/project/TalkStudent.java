/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月13日
 * @Description: 
 */
package com.sethnie.udp;

public class TalkStudent {

    public static void main(String[] args) {
        new Thread(new TalkReceive(8888,"student")).start();//接收
        new Thread(new TalkSend(7777,"localhost",9999)).start();//发送

    }

}
