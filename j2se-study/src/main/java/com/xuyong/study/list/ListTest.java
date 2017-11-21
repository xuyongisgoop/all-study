package com.xuyong.study.list;

import java.util.ArrayList;

import com.google.common.collect.Lists;

public class ListTest {

	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3, 4, 5, 6};
		ArrayList<Integer> newArrayList = Lists.newArrayList(arr);
		System.out.println(newArrayList.get(1));
	}
	
}
