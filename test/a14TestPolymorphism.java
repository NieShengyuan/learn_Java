/*
 * 测试多态Polymorphism
 * 多态是方法的多态，不是属性的多态（多态与属性无关）
 * 多态存在的3个必要条件：继承，方法重写，父类引用指向子类对象
 * 父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了
 */
package com.sethnie.oo;

public class a14TestPolymorphism {
	public static void main(String[] args) {
		Animal a = new Animal();
		Cat c = new Cat();
		Animal d = new Dog();//向上转型
		
		Dog d2 = (Dog) d;//强制向下转型
		d2.seeDoor();
		
		animalCry(a);
		animalCry(c);		
		animalCry(d);
	}
	//重载
	static void animalCry(Animal a) {
		a.sounds();
	}
}

class Animal{
	public void sounds() {
		System.out.println("make a sound");
	}
}
//继承
class Dog extends Animal{
	public void sounds() {
		System.out.println("www-www");
	}
	
	public void seeDoor() {
		System.out.println("see door");
	}
}
class Cat extends Animal{
	public void sounds() {
		System.out.println("mmm-mmm");
	}
}
