package com.xuyong.study.list;

public class MyLinkedListTest {
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(4);
		list.add(8);
		list.add(9);
		System.out.println(list.get(1));
		System.out.println(list.remove(1));
		System.out.println(list.get(1));
		System.out.println(list.size());
	}

}
