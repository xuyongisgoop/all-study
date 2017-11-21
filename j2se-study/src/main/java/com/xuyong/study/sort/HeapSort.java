package com.xuyong.study.sort;

public class HeapSort implements SortCommon{

	public void sort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			buildMaxHeap(arr, i);
			swap(arr, 0, i);
		}
	}

	private void buildMaxHeap(int[] arr, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i-- ) {
			int k = i;
			while (2 * k + 1 < lastIndex) {
				
			}
			int biggerIndex = 2 * k + 1;
			
		}
	}
	
	private void swap(int[] arr, int i, int i2) {
		
	}
	
}
