package com.xuyong.study.singleton;

public class Lazy {
	
	private static Lazy instance;
	
	private Lazy() {
		
	}
	
	public synchronized Lazy getInstance() {
		if (instance == null) {
			return new Lazy();
		}
		return instance;
	}
	
}
