package com.xuyong.study.queue;

import org.apache.commons.collections4.queue.CircularFifoQueue;

public class CircularFifoQueueTest {
	public static void main(String[] args) {
		CircularFifoQueue<Integer> queue = new CircularFifoQueue<Integer>(2);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		System.out.println(queue.element());
		System.out.println(queue.element());
//		System.out.println(queue.removje());
//		System.out.println(queue.element());
		System.out.println(queue.get(1));
	}
}
