package com.xuyong.study.aogrithum.fraction2decimal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 分数到小数
 * @Author: xuyong
 * @Date: 2022/11/10
 **/
public class FractionToDecimal {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4, 333));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long)numerator;
        long denominatorLong = (long)denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        StringBuilder sb = new StringBuilder();
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append("-");
        }
        long absNumerator = Math.abs(numeratorLong);
        long absDenominator = Math.abs(denominatorLong);
        Map<Long, Integer> indexMap = new HashMap<>();
        sb.append(absNumerator / absDenominator);

        sb.append(".");

        StringBuffer remindSb = new StringBuffer();
        int index = 0;
        long remind = absNumerator % absDenominator;
        while (remind != 0 && !indexMap.containsKey(remind)) {
            indexMap.put(remind, index);
            remind *= 10;
            remindSb.append(remind / absDenominator);
            System.out.println("remind / absDenominator = " + (remind / absDenominator));
            remind = remind % absDenominator;
            System.out.println("remind = " + remind);
            index++;
        }
        if (remind != 0) {
            System.out.println("indexMap.get(remind) = " + indexMap.get(remind));
            remindSb.insert(0, '(');
            remindSb.append(')');
        }
        sb.append(remindSb.toString());
        return sb.toString();
    }
}
