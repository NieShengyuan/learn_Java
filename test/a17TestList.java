package com.sethnie.oo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Collection接口下的list接口有一下常用实现类
 * 
 *         ArrayList:底层实现是数组，线程不安全，效率高，查询效率高，修改，插入，删除效率低。
 *         LinkedList:底层实现是链表，线程不安全，效率高，查询效率低，修改，插入，删除效率高。 
 *         Vector:线程安全，效率低，
 *
 */
public class a17TestList {
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog1());
		list.add(1234);//包装类的：自动装箱
		//list.remove("aaa");
		System.out.println(list.size());
		
		List list2 = new ArrayList();
		list2.add("aa");
		list2.add("bb");
		list.add(list);
		System.out.println(list.size()+"个元素");
		
		//和顺序有关的操作
		String str = (String)list.get(0);
		System.out.println(str);
		list.set(0, "haha");
		String str2 = (String) list.get(0);
		System.out.println(str2);
        System.out.println(list.size()+"个元素.");
	}
}
class Dog1{
	
}