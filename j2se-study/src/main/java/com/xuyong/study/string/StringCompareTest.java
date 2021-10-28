package com.xuyong.study.string;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Created by xuyong on 2019/3/29
 */
public class StringCompareTest {

    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(compareS("14", "9"));
        System.out.println(compareB("14", "9"));
    }

    private static int compareS(String a, String b) {
        return a.compareTo(b);
    }

    private static int compareB(String a, String b) {
        return new BigDecimal(a).compareTo(new BigDecimal(b));
    }
}
