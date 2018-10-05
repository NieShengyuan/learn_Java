/**
 * @version: v1.0
 * @Description: 实现装饰器
 * 1、抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 2、具体组件：需要装饰的对象
 * 3、抽象装饰类：包含了对抽象组件的引用以及装饰者共有的方法
 * 4、具体装饰类：被装饰的对象
 * @author: SethNie
 * @date: 下午8:09:20
 */
package com.sethnie.io;


public class DecorateTest {

    public static void main(String[] args) {
        Person p= new Person();
        p.say();
        
        //装饰
        Amplifier p1 = new Amplifier(p);
        p1.say();

    }

}
//接口
interface Say{
    void say();
}

class Person implements Say{
    //属性
    private int voice = 10;
    @Override
    public void say() {
        System.out.println("人的声音为："+this.getVoice());
    }
    public int getVoice() {
        return voice;
    }
    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say{
    private Person p;

    public Amplifier(Person p) {
        this.p = p;
    }
    @Override
    public void say() {
        System.out.println("人的声音为："+p.getVoice()*100);
        System.out.println("噪音。。。");
    }
    
}

