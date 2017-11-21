package com.xuyong.study.singleton;

public class CopyOfDoubleCheck {

	private static volatile CopyOfDoubleCheck instance;
	
	private CopyOfDoubleCheck() {
		
	}
	
	public static CopyOfDoubleCheck getInstance() {
		if (instance == null) {
			synchronized (CopyOfDoubleCheck.class) {
				if (instance == null) {
					instance = new CopyOfDoubleCheck();
				}
			}
		}
		return instance;
	}
	
}
