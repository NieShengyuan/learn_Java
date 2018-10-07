/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月7日
 * @Description: 模拟龟兔赛跑
 */
package com.sethnie.thread;

public class Racer implements Runnable{
    private String winner;//胜利者
    @Override
    public void run() {
        for(int steps=1;steps<=100;steps++) {
            //模拟休息
            if(Thread.currentThread().getName().equals("rabbit") && steps%20==0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if(flag) {
                break;
            }
            
        }
        
    }
    private boolean gameOver(int steps) {
        if(winner!=null) {
            return true;
        }else {
            if(steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner-->"+winner);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
    }

   
}
