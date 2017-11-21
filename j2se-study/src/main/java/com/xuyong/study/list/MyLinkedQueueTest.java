package com.xuyong.study.list;

public class MyLinkedQueueTest {

	public static void main(String[] args) {
		MyLinkedQueue queue = new MyLinkedQueue();
		queue.offer(5);
		queue.offer(6);
		System.out.println(queue.pull());
		queue.offer(10);
		System.out.println(queue.pull());
		queue.offer(5);
		queue.offer(3);
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
	}
	
}
