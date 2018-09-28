/*
 * 数组声明，操作
 * */
package com.sethnie.arrays;

public class a16TestArrays01 {
	public static void main(String[] args) {
		//声明并分配空间
		//默认初始化
		int[] arr01 = new int[10];//0
		String arr02[] = new String[5];//null
		User[] arr03 = new User[3];
		//动态初始化,挨个赋值
		arr03[0] = new User(1000,"SN");
		arr03[1] = new User(1000,"SN1");
		arr03[2] = new User(1000,"SN2");
		/*
		 * //静态初始化-------------------------------------------
		int[] arr01 = {2,4,567};
		User[] arr03 = {
						new User(1000,"SN"),
						new User(1000,"SN1"),
						new User(1000,"SN2")
						};
		*/		
		
		for(int i=0;i<arr03.length;i++) {
			System.out.println(arr03[i].getName());
		}
		
		for(int i=0;i<arr01.length;i++) {
			arr01[i] = 10*i;
		}
		
		for(int i=0;i<arr01.length;i++) {
			System.out.println(arr01[i]);
		}
		//foreach循环，只能读取元素的值，不能修改
		System.out.println("***************************");
		for(int m:arr01) {
			System.out.println(m);
		}
	}
}


class User{
	private int id;
	private String name;
	
	//构造器
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}