package com.xuyong.study.annotation;

import java.lang.reflect.Method;

/**
 * Created by xuyong on 2018/2/8.
 */
public class TestMain {

    public static void main(String[] args) {
        Method[] methods = ClassWithAnnotation.class.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(FirstAnnotation.class)) {
                System.out.println("get method : " + method.getName());
            }
        }
    }

}
