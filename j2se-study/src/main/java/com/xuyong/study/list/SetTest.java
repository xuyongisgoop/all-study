package com.xuyong.study.list;

import java.math.BigDecimal;

/**
 * Created by xuyong on 2018/2/28.
 */
public class SetTest {

    public static void main(String[] args) {
//        Set<String> s = Sets.newConcurrentHashSet();
//        s.add("XU");
//        s.add("YONG");
//        System.out.println(s.contains(null));
//        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println("xxx=" + stringBuilder.equals(""));
//        System.out.println(OrderStatusEnum.DELIVERING.getStatus());

        BigDecimal divide = BigDecimal.valueOf(201).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
        Double fee = 2.01;
        BigDecimal multiply = BigDecimal.valueOf(fee).multiply(BigDecimal.valueOf(100));
        System.out.println(multiply);
    }
}
