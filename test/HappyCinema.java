/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月10日
 * @Description: 线程同步 同步块
 */
package com.sethnie.Thread;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema {
    public static void main(String[] args) {
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(6);
        available.add(7);

        // 顾客需要的位置
        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);

        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(3);
        seats2.add(4);
        seats2.add(6);

        Cinema c = new Cinema(available, "HappyCinema");
        new Thread(new HappyCustomer(c, seats1), "nie").start();
        new Thread(new HappyCustomer(c, seats2), "xiao").start();
    }
}

//顾客
class HappyCustomer implements Runnable {

    Cinema cinema;
    List<Integer> seats;

    public HappyCustomer(Cinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "-->位置为：" + seats);
                System.out.println("------------\r\n");
            } else {
                System.out.println("\r\n出票失败" + Thread.currentThread().getName() + "-->位置不够");
                System.out.println("------------\r\n");
            }
        }
    }
}

class Cinema {
    List<Integer> available;// 可用位置
    String name;// 名称

    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    // 购票
    public boolean bookTickets(List<Integer> seats) {
        System.out.println("欢迎光临" + Thread.currentThread().getName() + "可用位置为：" + available);
        System.out.print("购买：" + seats + "  ");
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);

        // 相减
        copy.removeAll(seats);

        // 判断大小
        if (available.size() - copy.size() != seats.size()) {
            return false;
        }
        available = copy;

        return true;
    }
}
