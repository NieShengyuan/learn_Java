package com.sethnie.Collection;

import java.util.ArrayList;
import java.util.List;

public class TestEmployee {
	public static void main(String[] args) {
		//һ�����������������
		Employee e = new Employee(0301,"sethnie", 3000,"��Ŀ��","2007-10");
		Employee e2 = new Employee(0302,"sethnie2", 3100,"��ѧ��","2006-10");
		Employee e3 = new Employee(0303,"sethnie3", 3200,"��Ŀ��","2007-9");
		
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(e);
		list.add(e2);
		list.add(e3);
		printEmpName(list);
	}
	
	public static void printEmpName(List<Employee> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getName());
		}
	}
}
