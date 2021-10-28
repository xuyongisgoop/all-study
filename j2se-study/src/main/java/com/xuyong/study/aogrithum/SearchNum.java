package com.xuyong.study.aogrithum;

/**
 * Created by xuyong on 2021/10/27
 */
public class SearchNum {

    public static void main(String[] args) {
        int[] nums = {1,3};
        SearchNum searchNum = new SearchNum();
        int index = searchNum.search2(nums, 3);
        System.out.println(index);
    }

    /**
     * 最常见的二分查找法
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int length = nums.length;
        int result = -1;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    /**
     * 基于旋转列表的二分查找法
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int length = nums.length;
        int result = -1;
        int left = 0, right = length - 1;
        if (length == 1 && nums[0] == target) {
            result = 0;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] > target || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid + 1] > target || target > nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }

}
