/*
 * ������д(override)/����
 *Ҫ��
 *-----------------------------
 *  ==  ���������β��б���ͬ
 *  <=  ����ֵ���ͺ������쳣���ͣ�����С�ڵ��ڸ���
 *  >=  ����Ȩ�ޣ�������ڸ���
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
	/*�Լ̳еķ������ƻ���д
	 * */
	@Override
	public void run() {
		System.out.println("horse run");
	}
}
