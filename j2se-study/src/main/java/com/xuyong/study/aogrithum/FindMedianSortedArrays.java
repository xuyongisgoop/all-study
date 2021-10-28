package com.xuyong.study.aogrithum;

/**
 * Created by xuyong on 2021/4/21
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Size = nums1.length;
        int num2Size = nums2.length;
        double[] middleNums = new double[num1Size + num2Size];
        int middleIndex = (num1Size + num2Size) / 2;
        int num1Index = 0;
        int num2Index = 0;
        double result;
        int i = 0;
        while (num1Index < num1Size && num2Index < num2Size) {
            if (nums1[num1Index] < nums2[num2Index]) {
                middleNums[i++] = nums1[num1Index++];
            } else {
                middleNums[i++] = nums2[num2Index++];
            }
        }
        while (num1Index < num1Size) {
            middleNums[i++] = nums1[num1Index++];
        }
        while (num2Index < num2Size) {
            middleNums[i++] = nums2[num2Index++];
        }
        if (middleNums.length % 2 == 0) {
            result = (middleNums[middleIndex - 1] + middleNums[middleIndex]) / 2;
        } else {
            result = middleNums[middleIndex];
        }
        return result;
    }
}
