package com.sethnie.oo;
/*
 * 测试继承
 * */

public class a09TestExtends {
	public static void main(String[] args) {
		System.out.println("start test");
		Student sn = new Student("Seth Nie",22,"freedom");
		System.out.println(sn.name);
		System.out.println(sn.age);
		System.out.println(sn.majar);
	} 
}

class Person{
	String name;
	int age;
	
	public void rest() {
		System.out.println("Take a break");
	}
}

class Student extends Person{
	String majar;
	
	public void study() {
		System.out.println("work hard");
	}
	
	public Student(String name,int age,String major) {
		this.name  = name;
		this.age   = age;
		this.majar = major;
	}
}
