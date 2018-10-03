package com.sethnie.Iterator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a24InteratorForListAndSet {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		//通过索引遍历List
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		//通过迭代器遍历List
		for(Iterator<String> iter2 = list.iterator();iter2.hasNext();) {
			String str = (String) iter2.next();
			System.out.println(str);
			iter2.remove();
		}
		
		System.out.println(list.size()+"----------------");
		
		//HashSet为无序列表
		Set<String> set = new HashSet<String>();
		set.add("sa");
		set.add("sd");
		set.add("sn");
		
		//通过迭代器遍历Set
		//Iterator iter= set.iterator();
		//while(iter.hasNext()) {
		for(Iterator<String> iter = set.iterator();iter.hasNext();) {
			String str = (String) iter.next();
			System.out.println(str);
		}	
	}
}
