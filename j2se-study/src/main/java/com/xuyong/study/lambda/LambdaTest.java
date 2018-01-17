package com.xuyong.study.lambda;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xuyong on 2017/12/26.
 */
public class LambdaTest {

    public static void main(String[] args) {
        new LambdaTest().test1();
    }

    public void test1() {
        TestOrder order1 = new TestOrder();
        order1.setOrder_id(111111L);
        order1.setUser_code("100");
        order1.setUser_name("xxx");

        TestOrder order2 = new TestOrder();
        order2.setOrder_id(111111L);
        order2.setUser_code("100");
        order2.setUser_name("xxx");

        TestOrder order3 = new TestOrder();
        order3.setOrder_id(111111L);
        order3.setUser_code("100");
        order3.setUser_name("xxx");

        List<TestOrder> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        orders.stream().map(this :: convertToMap).collect(Collectors.toList()).forEach((v) -> System.out.println(v));
    }

    private Map<String, Object> convertToMap(TestOrder obj) {
        if(obj == null){
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return map;
    }

}
