package com.xuyong.study.list;

import java.util.Arrays;

public class ArrayCopyTest {
	public static void main(String[] args) {
		Object[] src = new Object[10];
		for (int i = 0; i < src.length; i++) {
			src[i] = i;
		}
		Object[] dest = new Object[20];
		System.out.println(Arrays.toString(src));
		System.arraycopy(src, 0, dest, 0, src.length);
		System.out.println(Arrays.toString(dest));
	}
}
