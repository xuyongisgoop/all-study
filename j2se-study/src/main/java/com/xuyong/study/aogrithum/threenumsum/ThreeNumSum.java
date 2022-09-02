package com.xuyong.study.aogrithum.threenumsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 三数之和
 * @Author: xuyong
 * @Date: 2022/8/18
 **/
public class ThreeNumSum {

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 4, 6, 1, -7, -5};
        List<List<Integer>> result = threeNumSum(input);
        System.out.println("result =" + result);
    }

    public static List<List<Integer>> threeNumSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < len - 2; i++) {
            //System.out.println("i = " + i);
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target = 0 - nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                //System.out.println("left = " + left + ", right = " + right);
                if ((right + 1 <= len - 1 && nums[right] == nums[right + 1]) || nums[left] + nums[right] > target) {
                    right--;
                } else if ((left - 1 >= i + 1 && nums[left - 1] == nums[left]) || nums[left] + nums[right] < target) {
                    left++;
                } else {
                    List<Integer> itemList = new ArrayList<>();
                    itemList.add(nums[i]);
                    itemList.add(nums[left++]);
                    itemList.add(nums[right--]);
                    result.add(itemList);
                }
            }
        }
        return result;
    }

}
