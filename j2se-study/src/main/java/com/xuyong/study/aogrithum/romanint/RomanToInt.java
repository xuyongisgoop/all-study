package com.xuyong.study.aogrithum.romanint;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/8/18
 **/
public class RomanToInt {
//    public static void main(String[] args) {
//        System.out.println(romanToInt("VIII"));
//    }

//    Map<String, Integer> targetMap = new HashMap<String, Integer>(){{
//        put("M", 1000);
//    }};
//        targetMap.put("M", 1000);
//        targetMap.put("D", 500);
//        targetMap.put("C", 100);
//        targetMap.put("L", 50);
//        targetMap.put("X", 10);
//        targetMap.put("V", 5);
//        targetMap.put("I", 1);

    Map<Character, Integer> targetMap = new HashMap<>();
    {
        targetMap.put('M', 1000);
        targetMap.put('D', 500);
        targetMap.put('C', 100);
        targetMap.put('L', 50);
        targetMap.put('X', 10);
        targetMap.put('V', 5);
        targetMap.put('I', 1);
    }


    public int romanToInt(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (i < len - 1 && targetMap.get(s.charAt(i)) < targetMap.get(s.charAt(i + 1))) {
                res -= targetMap.get(c);
            } else {
                res += targetMap.get(c);
            }
        }
        return res;
    }

}
