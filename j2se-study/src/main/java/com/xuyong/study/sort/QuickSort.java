package com.xuyong.study.sort;

public class QuickSort implements SortCommon {
	
	public void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	public void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int middle = getMiddleAndSort(arr, low, high);
			mergeSort(arr, low, middle);
			mergeSort(arr, middle + 1, high);
		}
	}
	
	private int getMiddleAndSort(int[] arr, int low, int high) {
		int begin = low;
		int end = high;
		int temp = arr[begin];
		while (begin < end) {
			while (begin < end && arr[end] >= temp) {
				end--;
			}
			arr[begin] = arr[end];
			while (begin < end && arr[begin] <= temp) {
				begin++;
			}
			arr[end] = arr[begin];
		}
		arr[begin] = temp;
		return begin;
	}
	
}
	