/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月10日
 * @Description: 协作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 */
package com.sethnie.cooperation;

public class CoTest01 {
    public static void main(String[] args) {
        SynSContainer container = new SynSContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynSContainer container;
    public Productor(SynSContainer container) {
        this.container = container;
    }
    public void run() {    
        //生产
        for(int i=0;i<100;i++) {
            System.out.println("生产第"+i+"个馒头");
            container.push(new Steamedbun(i));
        }
    }
}

//消费者
class Consumer extends Thread{
    SynSContainer container;
    public Consumer(SynSContainer container) {
        this.container = container;
    }
    public void run() {  
        //消费
        for(int i=0;i<100;i++) {
            System.out.println("消费第"+container.pop().id+"个馒头");
        }
    }
}

//缓冲区
class SynSContainer{
    Steamedbun[] buns = new Steamedbun[100];//存储容器
    int count = 0;//计数器
    //存储 生产
    public synchronized void push(Steamedbun bun) {
        //何时能生产 容器存在空间
        //不能生产，只有等待
        if(count == buns.length) {
            try {
                this.wait();//线程阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间 可以生产
        buns[count] = bun;
        count++;
        this.notifyAll();//通知消费 
    }
    //获取 消费
    public synchronized Steamedbun pop() {
        //何时消费：容器中存在数据，
        //没有数据只有等待
        if(count == 0) {
            try {
                this.wait();//线程阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据可以消费
        count--;
        Steamedbun bun = buns[count];
        this.notifyAll();//存在空间了，可以唤醒对方生产了
        return bun;
    }
}


//馒头
class Steamedbun{
    int id;
    public Steamedbun(int id) {
        this.id = id;
    }   
}

