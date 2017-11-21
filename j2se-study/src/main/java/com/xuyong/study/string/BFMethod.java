package com.xuyong.study.string;

public class BFMethod {

	public static void main(String[] args) {
		String source = "aafefdeeilbcddfeijifeifexxfejie";
		String pattern = "feiji";
		int index = getIndex(source, pattern);
		System.out.println("get index(JDK) is: " + source.indexOf(pattern));
		System.out.println("get index is: " + index);
	}

	private static int getIndex(String source, String pattern) {
		
		return 0;
	}
	
}
