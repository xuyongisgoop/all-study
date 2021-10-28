package com.xuyong.study.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ListTest {

	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3, 4, 5, 6};
		ArrayList<Integer> newArrayList = Lists.newArrayList(arr);
		System.out.println(newArrayList.get(1));

		System.out.println(newArrayList.subList(0, 6));

		System.out.println(Arrays.stream(arr).filter(i -> i > 30).collect(Collectors.toList()));

		String cityIds = "333,32,3";
        System.out.println(Arrays.asList(cityIds.split(",")).contains(3));
    }
}
