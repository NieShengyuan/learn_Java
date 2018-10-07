/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月7日
 * @Description: 
 * 创建线程方式一：
 * 1、创建：继承Thread+重写run
 * 2、启动：创建子类对象+start
 */
package com.sethnie.thread;

public class StardThread extends Thread{
    //线程入口点
    @Override
    public void run() {
        super.run();
        for(int i=0;i<20;i++) {
            System.out.println("song");
        }
    }

    public static void main(String[] args) {
        //创建子类对象
        StardThread st = new StardThread();
        //启动
        st.start();
        for(int i=0;i<20;i++) {
            System.out.println("coding");
        }

    }

}
