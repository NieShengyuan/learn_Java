package com.sethnie.oo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Collection�ӿ��µ�list�ӿ���һ�³���ʵ����
 * 
 *         ArrayList:�ײ�ʵ�������飬�̲߳���ȫ��Ч�ʸߣ���ѯЧ�ʸߣ��޸ģ����룬ɾ��Ч�ʵ͡�
 *         LinkedList:�ײ�ʵ���������̲߳���ȫ��Ч�ʸߣ���ѯЧ�ʵͣ��޸ģ����룬ɾ��Ч�ʸߡ� 
 *         Vector:�̰߳�ȫ��Ч�ʵͣ�
 *
 */
public class a17TestList {
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog1());
		list.add(1234);//��װ��ģ��Զ�װ��
		//list.remove("aaa");
		System.out.println(list.size());
		
		List list2 = new ArrayList();
		list2.add("aa");
		list2.add("bb");
		list.add(list);
		System.out.println(list.size()+"��Ԫ��");
		
		//��˳���йصĲ���
		String str = (String)list.get(0);
		System.out.println(str);
		list.set(0, "haha");
		String str2 = (String) list.get(0);
		System.out.println(str2);
        System.out.println(list.size()+"��Ԫ��.");
	}
}
class Dog1{
	
}