package com.sethnie.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a23TestMap02 {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("id", 0301);
		map.put("name", "sn");
		map.put("salary", 3000);
		map.put("department", "教学部");
		map.put("hireDate","2001-5");
		
		Map map2 = new HashMap();
		map2.put("id", 0302);
		map2.put("name", "sn2");
		map2.put("salary", 3200);
		map2.put("department", "教学部");
		map2.put("hireDate","2002-5");
		
		Map map3 = new HashMap();
		map3.put("id", 0303);
		map3.put("name", "sn3");
		map3.put("salary", 3300);
		map3.put("department", "教学部");
		map3.put("hireDate","2003-5");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map);
		list.add(map2);
		list.add(map3);
		
		printEmpName(list);
	}
	
	public static void printEmpName(List<Map> list) {
		for(int i=0;i<list.size();i++) {
			Map tempMap = list.get(i);
			System.out.println(tempMap.get("name")+"--"+tempMap.get("salary"));
		}
	}
}
