/*
 * super()����������
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

//�̳и���
class ChildClass extends FatherClass{
	public int value;
	
	//�Ը��෽�����޸�
	public void f() {
		super.f();//���ø���������ͨ����
		value = 200;//���������޸�
		System.out.println("ChildClass.value="+value);
		System.out.println(value);
		System.out.println(super.value);//���ø������ĳ�Ա����
	}
}
