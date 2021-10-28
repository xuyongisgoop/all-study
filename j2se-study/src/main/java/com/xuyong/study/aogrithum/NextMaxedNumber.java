package com.xuyong.study.aogrithum;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by xuyong on 2021/1/22
 */
public class NextMaxedNumber {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 1};
        int[] result1 = getNextMaxedNumberV1(input);
        System.out.println("result1 = " + Arrays.toString(result1));
        int[] result2 = getNextMaxedNumberV2(input);
        System.out.println("result2 = " + Arrays.toString(result2));
    }

    public static int[] getNextMaxedNumberV1(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max  = -1;
            int j = i + 1;
            while (j < 2 * arr.length) {
                if (arr[j % arr.length] > arr[i]) {
                    max = arr[j % arr.length];
                    break;
                }
                j++;
            }
            result[i] = max;
        }
        return result;
    }

    public static int[] getNextMaxedNumberV2(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i % arr.length] >= arr[stack.peek()]) {
                stack.pop();
            }
            result[i % arr.length] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i % arr.length);
        }
        return result;
    }

}
