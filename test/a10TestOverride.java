/*
 * 测试重写(override)/覆盖
 *要点
 *-----------------------------
 *  ==  方法名、形参列表相同
 *  <=  返回值类型和声明异常类型，子类小于等于父类
 *  >=  访问权限，子类大于父类
 * 
 * */
package com.sethnie.oo;

public class a10TestOverride {
	public static void main(String[] args) {
		Horse h = new Horse();
		h.run();
	}
}

class Vehicle{
	public void run() {
		System.out.println("run...");
	}
	public void stop() {
		System.out.println("stop");
	}
}

class Horse extends Vehicle {
	/*对继承的方法定制化重写
	 * */
	@Override
	public void run() {
		System.out.println("horse run");
	}
}
