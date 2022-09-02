package com.xuyong.study.aogrithum.twonumsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/8/18
 **/
public class TwoNumSum1 {
    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 4, 6};
        int target = 8;
        int[] result = getTwoNumberSum(input, target);
        System.out.println("result =" + Arrays.toString(result));
    }

    public static int[] getTwoNumberSum(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (sumMap.get(target - nums[i]) != null) {
                result[0] = nums[i];
                result[1] = target - nums[i];
                return result;
            } else {
                sumMap.put(nums[i], i);
            }
        }
        return null;
    }

}
