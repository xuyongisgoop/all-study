package com.xuyong.study.singleton;

public class InnerStatic {

	private static class InnerStaticClass {
		private static final InnerStatic instance = new InnerStatic();
	}
	
	private InnerStatic() {
		
	}
	
	public InnerStatic getInstance() {
		return InnerStaticClass.instance;
	}
	
}
