/*
 * 重写Object类 toString方法
 * */
package com.sethnie.oo;

public class a11TestObject {
	public static void main(String[] args) {
		//Object obj;
		//String str;
		User sn = new User("SN",22);
		System.out.println(sn.toString());
		
		User sm = new User("SM",21);
		System.out.println(sn.equals(sm));
		User sp = new User("SP",22);
		System.out.println(sn.equals(sp));
	}

}

class User{
	String name;
	int id;
	
	//实际应用中toString()重写是为对象提供特定的输出模式
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}
	
	public User(String name,int id) {
		this.id = id;
		this.name = name;
	}
	
	//实际应用中equals()重写是对特定对象进行判断
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
