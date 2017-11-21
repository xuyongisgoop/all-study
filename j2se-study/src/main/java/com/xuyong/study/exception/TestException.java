package com.xuyong.study.exception;

public class TestException {

	public static void openFile() throws MyException {
		int i = 0;
		if (i == 0) {
			throw new MyException("i == 0");
		}
	}
	
	public static void main(String[] args) {
		try {
			openFile();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
