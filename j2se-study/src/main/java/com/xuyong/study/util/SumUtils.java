package com.xuyong.study.util;

/**
 * Created by xuyong on 2018/5/27.
 */
public class SumUtils {

    public static void main(String[] args) {
        double[] vals = {61.25,12.39,12.39,10.13,10.13,37.97,37.97,-55.81,-55.81,21.37,21.37,3.35,3.35,-13.98,-13.98,7.32,7.32,-14.68,-14.68,-4.00,-4.00,-4.00,-4.00};
        double result = 0;
        for (double val : vals) {
            result = result + val;
        }
        System.out.println(result);
    }
}
