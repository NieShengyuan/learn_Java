package com.sethnie.Tcollection;

import java.util.HashMap;
import java.util.Map;

public class a20TestMap {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("SethNie",new Partner("zhangmanyu"));
		map.put("three zhang",new Partner("yangmi"));
		
		Partner pa = (Partner) map.get("SethNie");
		System.out.println(pa.name);
	}
}
class Partner{
	String name;
	public Partner(String name) {
		this.name = name;
	}
}
