package com.xuyong.study.sort;

public class InsertSort implements SortCommon{
	
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				int temp = arr[i];
				int index = i - 1;
				while (temp < arr[index]) {
					arr[index+1] = arr[index];
					index--;
					if (index < 0) {
						break;
					}
				}
				arr[index+1]=temp;
			}
		}
	}
	
}
