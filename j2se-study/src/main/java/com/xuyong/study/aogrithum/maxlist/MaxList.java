package com.xuyong.study.aogrithum.maxlist;

import java.util.Arrays;

/**
 * @Description: 给个数组返回最大的数字组合
 * @Author: xuyong
 * @Date: 2022/8/14
 **/
public class MaxList {
    // 20 209
    // 20209, 20920
    // 19 201
    // 19201 20119

    public static void main(String[] args) {
        //int[] nums = {3,30,34,5,9};
        int[] nums = {0, 3, 30, 34, 5, 9};
        System.out.println(getMax(nums));
    }

    private static String getMax(int[] nums) {
        int len = nums.length;
        Integer[] list = new Integer[len];
        for (int i = 0; i < len; i++) {
            list[i] = nums[i];
        }

        Arrays.sort(list, (x, y) -> {
            int xa = 10, ya = 10;
            while (xa <= x) {
                xa *= 10;
            }
            while (ya <= y) {
                ya *= 10;
            }
            //System.out.println("x = " + x + ", y = " + y + ", xa = " + xa + ", ya = " + ya + ", " + (y * xa + x) + " - " + (x * ya + y) + " result = " + ((y * xa + x) - (x * ya + y)));
            return (y * xa + x) - (x * ya + y);
        });

        //System.out.println(Arrays.toString(list));
        if (list[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(list[i]);
        }
        return sb.toString();
    }

}
