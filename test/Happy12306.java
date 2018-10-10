/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月10日
 * @Description: 线程同步 同步方法
 */
package com.sethnie.Thread;

public class Happy12306 {

    public static void main(String[] args) {
        Web12306 c = new Web12306(4, "happy sn");
        new Passenger(c, "sn", 2).start();
        new Passenger(c, "sM", 1).start();
    }

}

//顾客
class Passenger extends Thread {// 代理
    int seats;

    public Passenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }
}

//火车票网
class Web12306 implements Runnable {
    int available;// 可用位置
    String name;// 名称

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger p = (Passenger) Thread.currentThread();
        boolean flag = this.bookTickets(p.seats);
        if (flag) {
            System.out.println("出票成功" + p.getName() + "-->票数为：" + p.seats);
            System.out.println("------------\r\n");
        } else {
            System.out.println("\r\n出票失败" + p.getName() + "-->票数不够");
            System.out.println("------------\r\n");
        }

    }

    // 购票
    public synchronized boolean bookTickets(int seats) {
        System.out.println("欢迎光临" + Thread.currentThread().getName() + "可用位置为：" + available);
        System.out.print("购买：" + seats + "  ");
        if (seats > available) {
            return false;
        }
        available -= seats;

        return true;
    }
}
