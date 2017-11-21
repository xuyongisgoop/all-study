package com.xuyong.study.list;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockArrayQueue {
	private int front;
	private int rear;
	Object[] arr;
	
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	public MyBlockArrayQueue(int size) {
		arr = new Object[size];
		front = rear = 0;
	}
	
	public boolean offer(Object data) {
		lock.lock();
		try {
			while (front == ((rear + 1) % arr.length)) {
				System.out.println("the queue is full!!, front=" + front + ", rear=" + rear);
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			arr[rear] = data;
			rear = (rear + 1) % arr.length;
			System.out.println("add new num: " + data);
			condition.signal();
			return true;
		} finally {
			lock.unlock();
		}
	}
	
	public Object pull() {
		lock.lock();
		try {
			while (front == rear) {
				System.out.println("the queue is empty");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Object result = arr[front];
			front = (front + 1) % arr.length;
			condition.signal();
			return result;
		} finally {
			lock.unlock();
		}
	}
	
}
