package com.xuyong.study.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 比较两个list是否相同
 * @Author: xuyong
 * @Date: 2022/11/7
 **/
public class CompareTwoList {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(2);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);
        System.out.println(CompareTwoList.compareList(list1, list2));
        Integer one = new Integer(1);
        Integer two = new Integer(1);
        System.out.println(one.equals(two));
    }

    public static <T extends Comparable<T>> boolean compareList(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int len = list1.size();
        for (int i = 0; i < len; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

}
