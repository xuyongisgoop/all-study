package com.xuyong.study.singleton;

public class Hungry {

	private static Hungry instance = new Hungry();
	
	private Hungry() {
		
	}
	
	public Hungry getInstance() {
		return instance;
	}
}
