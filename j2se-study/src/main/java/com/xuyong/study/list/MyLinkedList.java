package com.xuyong.study.list;

public class MyLinkedList {
	private Node head;
	private int size;

	protected MyLinkedList() {
		this.head = new Node(null, null);
		this.size = 0;
	}

	class Node {
		Object data;
		Node next; 
		
		protected Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public boolean add(Object data) {
		Node node = head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new Node(data, null);
		size++;
		return true;
	}
	
	public Object remove(int index) {
		int i = 0;
		Object result = null;
		Node node = head;
		while (node.next != null) {
			Node tempNode = node.next;
			if (i == index) {
				result = tempNode.data;
				node.next = tempNode.next;
				tempNode.next = null;
				break;
			}
			node = tempNode;
			i++;
		}
		size--;
		return result;
	}
	
	public Object get(int index) {
		int i = 0;
		Object result = null;
		Node node = head;
		while (node.next != null) {
			Node tempNode = node.next;
			if (i == index) {
				result = tempNode.data;
				break;
			}
			node = tempNode;
			i++;
		}
		return result;
	}

	public int size() {
		return size;
	}
	
}
