package com.xuyong.study.singleton;

public class DoubleCheck {
	private static volatile DoubleCheck instance;
	
	private DoubleCheck() {
		
	}
	
	public DoubleCheck getInstance() {
		if (instance == null) {
			synchronized (DoubleCheck.class) {
				if (instance == null) {
					return new DoubleCheck();
				}
			}
		}
		return instance;
	}
}
