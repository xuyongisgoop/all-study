package com.xuyong.study.aogrithum.subarray;

/**
 * @Description: 连续子数组的最大和
 * @Author: xuyong
 * @Date: 2022/8/2
 **/
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {8, 7, 3, -1, -30, 4, 5, 1, 2};
        int result = getMaxSum(nums);
        System.out.println("get result = " + result);
    }

    public static int getMaxSum(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
