package com.xuyong.study.aogrithum.quickdivide;

/**
 * @Description: 快速乘
 * @Author: xuyong
 * @Date: 2022/9/2
 **/
public class QuickDivide {

    public static void main(String[] args) {
        int result = divide(30, 5);
        //boolean result = quickAdd(-5, 536870912, -30);
        System.out.println("divide result = " + result);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int left = 1;
        int right = Integer.MAX_VALUE;
        int ans = 0;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            System.out.println("left = " + left + ", right = " + right);
            if (quickAdd(divisor, mid, dividend)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return ans;
    }

    public static boolean quickAdd(int divisor, int mid, int dividend) {
        System.out.println("quickAdd divisor = " + divisor + ", mid = " + mid + ", dividend = " + dividend);
        int result = 0;
        int add = divisor;
        while (mid > 0) {
            if ((mid & 1) == 1) {
                if (result + add < dividend) {
                    return false;
                }
                result += add;
            }
            if (mid != 1) {
                if (add + add < dividend) {
                    return false;
                }
                add += add;
            }
            mid >>= 1;
            System.out.println("add = " + add + ", mid = " + mid);
        }
        System.out.println("quickAdd result = " + result + ", boolean = " + (result >= dividend));
        return result >= dividend;
    }

}
