/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月10日
 * @Description: 多线程性能分析
 */
package com.sethnie.Thread;

public class SynWeb12306 {
   
    public static void main(String[] args) {
        //一份资源
        SafeWeb12306 web = new SafeWeb12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"SN1").start();
        new Thread(web,"SN2").start();
        new Thread(web,"SN3").start();
    }
}
class SafeWeb12306 implements Runnable{
    //票数
    private int ticketNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while(flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            test5();
        }
        
    }
    
  
    //线程安全：尽可能锁定合理的范围（数据完整性）
    //double check
    public synchronized void test5() {
        if (ticketNums <= 0) {//考虑无票的情况
            flag = false;
            return;
        } 
        synchronized(this) {
            if (ticketNums <= 0) {//考虑最后一张票的情况
                flag = false;
                return;
            } 
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        
    }
    //范围太小。锁不住
    public synchronized void test4() {
        synchronized(this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            } 
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        
    }
    //线程不安全  ticketNums对象在变
    public synchronized void test3() {
        synchronized((Integer)ticketNums) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            } 
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        
    }
    //线程安全 范围太大--》效率低下
    public synchronized void test2() {
        synchronized(this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
        
        
    }
    
    //线程安全 同步
    public synchronized void test1() {
        if(ticketNums<=0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
    }
    
   
}
