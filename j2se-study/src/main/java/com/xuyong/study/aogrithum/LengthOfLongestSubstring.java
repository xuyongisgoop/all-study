package com.xuyong.study.aogrithum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuyong on 2021/4/17
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int a = 9;
        int b = 9;
        System.out.println(lengthOfLongestSubstring2("dvdf"));
    }

    public int lengthOfLongestSubstring1(String s) {
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder beginEnd = new StringBuilder();
            char beginChar = s.charAt(i);
            beginEnd.append(beginChar);
            for (int j = i + 1; j < s.length(); j++) {
                char endChar = s.charAt(j);
                if (beginEnd.indexOf(String.valueOf(endChar)) == -1) {
                    beginEnd.append(endChar);
                    break;
                }
            }
            if (beginEnd.length() > maxCount) {
                maxCount = beginEnd.length();
            }
        }
        return maxCount;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> charSet = new HashSet<>();
        int maxCount = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
            if (i == j) {
                j++;
            }
            while (j < s.length() && !charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j));
                j++;
            }
            if (charSet.size() > maxCount) {
                maxCount = charSet.size();
            }
            charSet.remove(s.charAt(i));
        }
        return maxCount;
    }
}
