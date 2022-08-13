package com.xuyong.study.aogrithum.reversearray;

/**
 * @Description: 翻转有序数组找最小值
 * @Author: xuyong
 * @Date: 2022/8/2
 **/
public class ReverseArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int min = findMin(nums);
        System.out.println("get result = " + min);
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 使用二分查找方式进行查找
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
            System.out.println("left = " + left + ", right = " + right);
        }
        return nums[right];
    }

}
