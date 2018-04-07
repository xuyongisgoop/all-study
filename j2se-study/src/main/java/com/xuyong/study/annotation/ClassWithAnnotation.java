package com.xuyong.study.annotation;

/**
 * Created by xuyong on 2018/2/8.
 */
public class ClassWithAnnotation {

    @FirstAnnotation(name = "myName", value = "myValue")
    public void testRun() {
        System.out.println("begin run testRun");
    }

}
