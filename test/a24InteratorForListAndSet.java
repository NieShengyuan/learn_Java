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
		//ͨ����������List
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		//ͨ������������List
		for(Iterator<String> iter2 = list.iterator();iter2.hasNext();) {
			String str = (String) iter2.next();
			System.out.println(str);
			iter2.remove();
		}
		
		System.out.println(list.size()+"----------------");
		
		//HashSetΪ�����б�
		Set<String> set = new HashSet<String>();
		set.add("sa");
		set.add("sd");
		set.add("sn");
		
		//ͨ������������Set
		//Iterator iter= set.iterator();
		//while(iter.hasNext()) {
		for(Iterator<String> iter = set.iterator();iter.hasNext();) {
			String str = (String) iter.next();
			System.out.println(str);
		}	
	}
}
