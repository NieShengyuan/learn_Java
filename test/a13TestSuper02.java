/*
 * 继承树追溯
 * */
package com.sethnie.oo;

public class a13TestSuper02 {
	public static void main(String[] args) {
		System.out.println("start create ChildClass object");
		new ChildClass2();
	}
}

//所有构造器的第一句话都是调用super方法，继承父类
class FatherClass2{
	public FatherClass2() {
		//super();//默认存在,继承了object
		System.out.println("create FatherClass");
	}
}
//构造方法调用顺序：先向上追溯到object，然后再依次向下执行类的初始化块和构造方法，直到当前子类为止。
class ChildClass2 extends FatherClass2{
	public ChildClass2() {
		super();//默认存在，会直接继承父类。
		//顺序是：先调父类对象构造器object，建好父类对象，再往回追溯，最终建好子类对象
		System.out.println("create ChildClass");
	}
}