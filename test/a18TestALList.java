package com.sethnie.oo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 自己实现一个ArrayList，帮助我们更好理解ArrayList类的底层结构
 * */
public class a18TestALList {
	
	private Object[] elementData;
	private int size;
	
	public a18TestALList() {
		this(10);
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	
	public a18TestALList(int initialCapacity) {
		if(initialCapacity<0) {
			try {
				throw new Exception();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		elementData = new Object[initialCapacity];
	}
	
	public void add(Object obj) {
		//数组扩容和数据迁移
		if(size>=elementData.length) {
			Object[] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		
		elementData[size++]=obj;
	}
	public Object get(int index) {
		if(index<0||index>=size) {
			try {
				throw new Exception();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return elementData[index];
	}
	
	public static void main(String[] args) {
		a18TestALList list = new a18TestALList(3);
		
		list.add("aaa");
		list.add(1234);//包装类的：自动装箱
		list.add("aaa");
		list.add(1234);//包装类的：自动装箱
		list.add("aaa");
		list.add(1234);//包装类的：自动装箱
		System.out.println(list.size);
		System.out.println(list.get(6));
	}
}
