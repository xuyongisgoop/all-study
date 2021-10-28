package com.xuyong.study.aogrithum;

/**
 * Created by xuyong on 2021/10/28
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 3, 4, 4, 5, 8};
        SearchRange searchRange = new SearchRange();
        System.out.println(searchRange.searchRange(input, 4, true));
        System.out.println(searchRange.searchRange(input, 4, false));
    }

    public int searchRange(int[] nums, int target, boolean ifEqual) {
        int length = nums.length;
        int left = 0, right = length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (ifEqual && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
