package com.xuyong.study.list;

import java.util.Random;

public class MyBlockArrayQueueTest {
	static MyBlockArrayQueue blockQueue = new MyBlockArrayQueue(10);

	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {
					blockQueue.offer(new Random().nextInt(100));
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("get new num:" + blockQueue.pull());
				}
			}
		}).start();
	}
	
}
