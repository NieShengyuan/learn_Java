/*
 * LinkedList增改删查
 * (文件包含Node.java)
 * */
package com.sethnie.Tcollection;

public class a19TestLinkList {
	private Node first;
	private Node last;
	private int size;
	
	public void add(Object obj) {
		Node n = new Node();
		if(first==null) {
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			first = n;
			last = n;
		}else {
			//直接往last节点后增加新的节点
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			last = n;
		}
		size++;
	}
	public void add(int index,Object obj) {
		Node temp = node(index);
		Node newNode = new Node();
		newNode.obj = obj;
		if(temp!=null) {
			Node up = temp.previous;
			up.next = newNode;
			newNode.previous = up;
			
			newNode.next = temp;
			temp.previous = newNode;
			size++;
		}
	}
	
	public void remove(int index) {
		Node temp = node(index);
		if(temp!=null) {
			Node up = temp.previous;
			Node down = temp.next;
			up.next = down;
			down.previous = up;
			size--;
		}
	}
	public Node node(int index ) {
		Node temp = null;
		RangeCheck(index);
		if(first!=null) {
			temp = first;
			for(int i=0;i<index;i++) {
				temp = temp.next;
			}
		}
		return temp;
	}
	public int size() {
		return size;
	}
	public Object get(int index) {
		Node temp = node(index);
		if(temp!=null) {
			return temp.obj;
		}
		else
			return null;
		
	}
	private void RangeCheck(int index) {
		if(index<0||index>=size) {
			try {
				throw new Exception();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		a19TestLinkList list = new a19TestLinkList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		System.out.println(list.size());
		//list.remove(1);
		list.add(1, "testAdd");
		System.out.println(list.size());
		for(int i=0;i<list.size;i++) {
			System.out.println(list.get(i));
		}
	}
}


