package com.xuyong.study.aogrithum.twonumsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: 最简单的两数之和
 * @Author: xuyong
 * @Date: 2022/7/27
 **/
public class TwoNumSum {

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 4, 6};
        int target = 8;
        int[] result = getTwoNumberSum(input, target);
        System.out.println("result =" + Arrays.toString(result));
    }

    public static int[] getTwoNumberSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            int first = nums[i];
            map.put(first, i);
            if (!Objects.isNull(map.get(target - first))) {
                int second = map.get(target - first);
                result[0] = first;
                result[1] = second;
                return result;
            }
        }
        return null;
    }

}
