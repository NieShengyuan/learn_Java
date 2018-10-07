/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月7日
 * @Description: 
 */
package com.sethnie.thread;

public class Web12306 implements Runnable{
    //票数
    private int ticketNums = 99;
    
    @Override
    public void run() {
        while(true) {
            if(ticketNums<0){
                break;
            }
            try {
                Thread.sleep(200);//网络延时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
        
    }
    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"SN1").start();
        new Thread(web,"SN2").start();
        new Thread(web,"SN3").start();
    }



}
