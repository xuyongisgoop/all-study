package com.xuyong.study.sort;

public class MergeSort implements SortCommon{

	public void sort(int[] arr) {
		int[] brige = new int[arr.length];
		branch(arr, brige, 0, arr.length - 1);
	}

	private void branch(int[] arr, int[] brige, int begin, int end) {
		if (begin < end) {
			int middle = (begin + end) / 2;
			branch(arr, brige, begin, middle);
			branch(arr, brige, middle + 1, end);
			merge(arr, brige, begin, middle, end);
		}
	}

	private void merge(int[] arr, int[] brige, int begin, int middle, int end) {
		int left = begin;
		int right = middle + 1;
		int index = begin;
		while (left <= middle && right <= end) {
			if (arr[left] < arr[right]) {
				brige[index++] = arr[left++];
			} else {
				brige[index++] = arr[right++];
			}
		}
		while (left <= middle) {
			brige[index++] = arr[left++];
		}
		while (right <= end) {
			brige[index++] = arr[right++];
		}
		copyArr(arr, brige, begin, end);
	}

	private void copyArr(int[] arr, int[] brige, int begin, int end) {
		while (begin <= end) {
			arr[begin] = brige[begin];
			begin++;
		}
	}

}
