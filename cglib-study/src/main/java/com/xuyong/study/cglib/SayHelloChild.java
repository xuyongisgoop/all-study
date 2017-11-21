package com.xuyong.study.cglib;

public class SayHelloChild extends SayHello{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4536552045982471872L;

	public void say() {
		System.out.println("begin");
		super.say();
		System.out.println("after");
	}
	
}