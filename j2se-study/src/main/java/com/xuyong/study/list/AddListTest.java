package com.xuyong.study.list;

import java.util.Collections;
import java.util.List;

/**
 * Created by xuyong on 2019-09-19
 */
public class AddListTest {

    public static void main(String[] args) {
        Long orderId = 234242424242L;
        System.out.println(orderId.toString());
        List<Object> members = Collections.emptyList();
        System.out.println(members);
        members.add(orderId);
    }
}
