package com.xuyong.study.list;

public class MyBlockLinkedQueue {
	private Node front;
	private Node rear;
	private int size;
	
	public static final int CAPACITY = 10;
	
	class Node {
		Object data;
		Node next;
		
		public Node(Object data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
	
	public MyBlockLinkedQueue() {
		Node node = new Node(null, null);
		this.front = node;
		this.rear = node;
	}
	
	public synchronized boolean offer(Object data) {
		while (size >= CAPACITY) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Node newnode = new Node(data, null);
		rear.next = newnode;
		rear = newnode;
		System.out.println("add new num: " + data);
		size++;
		this.notify();
		return true;
	}
	
	public synchronized Object pull() {
		while (front == rear) {
			try {
				System.out.println("queue is empty size=" + size + ", front == rear = " + (front == rear) + "");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Node tempnode = front.next;
		front.next = tempnode.next;
		if (tempnode.next == null) {
			rear = front;
		}
		tempnode.next = null;
		size--;
		this.notify();
		return tempnode.data;
	}
	
	public int size() {
		return size;
	}

}
