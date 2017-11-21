package com.xuyong.study.general;

public class MyStudent<T> {

	private T name;
	
	public void printName(T name) {
		System.out.println(name);
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}
	
}

class MySmallStudent<T> extends MyStudent<T> {
	
}
