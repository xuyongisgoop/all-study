package com.xuyong.study.singleton;

public class CopyOfInnerStatic {
	private CopyOfInnerStatic() {
		
	}
	
	public static CopyOfInnerStatic getInstance() {
		return CopyOfInnerStaticI.instance;
	}
	
	private static class CopyOfInnerStaticI {
		private static final CopyOfInnerStatic instance = new CopyOfInnerStatic(); 
	}
	
}
