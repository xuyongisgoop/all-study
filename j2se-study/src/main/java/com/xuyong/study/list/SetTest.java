package com.xuyong.study.list;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by xuyong on 2018/2/28.
 */
public class SetTest {

    public static void main(String[] args) {
        Set<String> s = Sets.newConcurrentHashSet();
        s.add("XU");
        s.add("YONG");
        System.out.println(s.contains(null));
    }
}
