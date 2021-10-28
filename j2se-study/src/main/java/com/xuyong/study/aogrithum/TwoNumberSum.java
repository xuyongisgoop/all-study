package com.xuyong.study.aogrithum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyong on 2021/1/25
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 4, 6};
        int target = 8;
        int[] result = getTwoNumberSum(input, target);
        System.out.println("result =" + Arrays.toString(result));
    }

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param arr
     * @param target
     * @return
     */
    private static int[] getTwoNumberSum(int[] arr, int target) {
        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                result = new int[]{i, map.get(target - arr[i])};
                break;
            }
            map.put(arr[i], i);
        }
        return result;
    }

}
