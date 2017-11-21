package com.xuyong.study.list;

public class MyLinkedQueue {
	private Node front;
	private Node rear;
	
	class Node {
		Object data;
		Node next;
		
		public Node(Object data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
	
	public MyLinkedQueue() {
		Node node = new Node(null, null);
		this.front = node;
		this.rear = node;
	}
	
	public boolean offer(Object data) {
		Node newnode = new Node(data, null);
		rear.next = newnode;
		rear = newnode;
		return true;
	}
	
	public Object pull() {
		if (front == rear) {
			System.out.println("queue is empty");
			return null;
		}
		Node tempnode = front.next;
		front.next = tempnode.next;
		if (tempnode.next == null) {
			rear = front;
		}
		tempnode.next = null;
		return tempnode.data;
	}

}
