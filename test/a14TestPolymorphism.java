/*
 * ���Զ�̬Polymorphism
 * ��̬�Ƿ����Ķ�̬���������ԵĶ�̬����̬�������޹أ�
 * ��̬���ڵ�3����Ҫ�������̳У�������д����������ָ���������
 * ��������ָ�����������øø������õ���������д�ķ�������ʱ��̬�ͳ�����
 */
package com.sethnie.oo;

public class a14TestPolymorphism {
	public static void main(String[] args) {
		Animal a = new Animal();
		Cat c = new Cat();
		Animal d = new Dog();//����ת��
		
		Dog d2 = (Dog) d;//ǿ������ת��
		d2.seeDoor();
		
		animalCry(a);
		animalCry(c);		
		animalCry(d);
	}
	//����
	static void animalCry(Animal a) {
		a.sounds();
	}
}

class Animal{
	public void sounds() {
		System.out.println("make a sound");
	}
}
//�̳�
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
