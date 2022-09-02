package com.xuyong.study.aogrithum.equalslist;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description: 比较两个数组是否相同
 * @Author: xuyong
 * @Date: 2022/8/16
 **/
public class EqualsList {

    public static void main(String[] args) {
        List<String> list1 = Lists.newArrayList("1", "3", "3");
        List<String> list2 = Lists.newArrayList("1", "2", "3");
        System.out.println(compareList(list1, list2));
    }

    public static <E> boolean compareList(List<E> list1, List<E> list2) {
        int len1 = list1.size();
        int len2 = list2.size();
        if (len1 == 0 || len2 == 0 || len1 != len2) {
            return false;
        }

        for (int i = 0; i < len1; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

}
