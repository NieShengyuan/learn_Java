/*
 * �̳���׷��
 * */
package com.sethnie.oo;

public class a13TestSuper02 {
	public static void main(String[] args) {
		System.out.println("start create ChildClass object");
		new ChildClass2();
	}
}

//���й������ĵ�һ�仰���ǵ���super�������̳и���
class FatherClass2{
	public FatherClass2() {
		//super();//Ĭ�ϴ���,�̳���object
		System.out.println("create FatherClass");
	}
}
//���췽������˳��������׷�ݵ�object��Ȼ������������ִ����ĳ�ʼ����͹��췽����ֱ����ǰ����Ϊֹ��
class ChildClass2 extends FatherClass2{
	public ChildClass2() {
		super();//Ĭ�ϴ��ڣ���ֱ�Ӽ̳и��ࡣ
		//˳���ǣ��ȵ������������object�����ø������������׷�ݣ����ս����������
		System.out.println("create ChildClass");
	}
}