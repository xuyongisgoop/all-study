package com.xuyong.study.aogrithum.romanint;

class IntToRoman {
    static int[] keyArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] valueArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

    public static String intToRoman(int num) {
        int len = keyArr.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int key = keyArr[i];
            String value = valueArr[i];
            System.out.println("key = " + key + ", value = " + value);
            while (num - key >= 0) {
                num -= key;
                res.append(value);
            }
            if (num == 0) {
                break;
            }
        }
        return res.toString();
    }
}