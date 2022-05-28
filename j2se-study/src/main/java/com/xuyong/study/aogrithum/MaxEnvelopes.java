package com.xuyong.study.aogrithum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xuyong on 2021/12/26
 */
public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0] && o1[1] < o2[1]) {
                    return 1;
                } else if (o1[0] == o2[0] && o1[1] == o2[1]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = envelopes[i][1];
        }
        return lengthOfLIS(nums);
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int d = 0; d < nums.length; d++) {
            dp[d] = 1;
        }
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int item : dp) {
            result = item > result ? item : result;
        }
        return result;
    }

}
