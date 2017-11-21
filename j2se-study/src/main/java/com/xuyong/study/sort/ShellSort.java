package com.xuyong.study.sort;

public class ShellSort implements SortCommon{

	public void sort(int[] arr) {
		int[] factor = {7, 5, 3, 1};
		for (int i = 0; i < factor.length; i++) {
			shellSort(arr, i);
		}
	}
	
	private void shellSort(int[] arr, int inc) {
		for (int i = inc; i < arr.length; i++) {
			if (arr[i] < arr[i - inc]) {
				int temp = arr[i];
				int index = i - inc;
				while (temp < arr[index]) {
					arr[index+1] = arr[index];
					index-=inc;
					if (index < 0) {
						break;
					}
				}
				arr[index+inc]=temp;
			}
		}
	}

}
