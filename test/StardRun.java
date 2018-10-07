/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月7日
 * @Description: 
 * 创建线程方式二：
 * 1、创建：实现Runnable+重写run
 * 2、启动：创建实现类对象+Thread对象+start
 * 
 * 推荐：避免单继承的局限性，优先使用接口
 * 方便共享资源
 */
package com.sethnie.thread;

public class StardRun implements Runnable{
    //线程入口点
    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            System.out.println("song");
        }
    }

    public static void main(String[] args) {
        //创建实现类对象
        StardRun sr = new StardRun();
        //创建代理类对象
        Thread t = new Thread(sr);
        //启动
        t.start();//不保证立即运行CPU调用
        
        //以上等价于
        //new Thread(new StardRun()).start();//不会多次调用的情况
        
        for(int i=0;i<20;i++) {
            System.out.println("coding");
        }

    }

}
