package com.xuyong.study.aogrithum.searchnum;

/**
 * @Description: 二分查找的测试
 * @Author: xuyong
 * @Date: 2022/8/2
 **/
public class SearchNum {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int index = find(nums, 4);
        System.out.println("get result index = " + index);
    }

    public static int find(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                break;
            }
            System.out.println("left = " + left + ", right = " + right);
        }
        return result;
    }


}
