package com.xuyong.study.aogrithum;

import java.util.Arrays;

/**
 * Created by xuyong on 2021/10/26
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] input = {1,5,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(input);
    }

    public void nextPermutation(int[] nums) {
        int numSize = nums.length;
        int i = numSize - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            if (i - 1 >= 0) {
                i--;
            }
        }
        int p = i - 1;
        int q = i;
        if (p >= 0) {
            while (q + 1 < numSize) {
                if (nums[p] >= nums[q + 1]) {
                    break;
                } else {
                    q++;
                }
            }
            swap(nums, p, q);
        }
        reverse(nums, p + 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
