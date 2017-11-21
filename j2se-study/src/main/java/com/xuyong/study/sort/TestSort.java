package com.xuyong.study.sort;

import java.util.Arrays;

public class TestSort {
	public static void main(String[] args) {
		int[] arr = {100, 20, 30, 21, 11, 57, 89, 22, 81};
		//int[] arr = {10, 20};
		SortCommon sortObj = new InsertSort();
		System.out.println(Arrays.toString(arr));
		sortObj.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
