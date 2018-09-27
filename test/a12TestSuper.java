/*
 * super()父类对象调用
 * 
 * */
package com.sethnie.oo;

public class a12TestSuper {
	public static void main(String[] args) {
		new ChildClass().f();
	}
}

class FatherClass{
	public int value;
	
	public void f() {
		value = 100;
		System.out.println("FatherClass.value="+value);
	}
}

//继承父类
class ChildClass extends FatherClass{
	public int value;
	
	//对父类方法做修改
	public void f() {
		super.f();//调用父类对象的普通方法
		value = 200;//对内容做修改
		System.out.println("ChildClass.value="+value);
		System.out.println(value);
		System.out.println(super.value);//调用父类对象的成员变量
	}
}
