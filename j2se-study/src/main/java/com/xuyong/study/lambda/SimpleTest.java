package com.xuyong.study.lambda;

/**
 * Created by xuyong on 2018/1/20.
 */
public class SimpleTest {

    public Integer mathAdd(int a, int b, ISimple<Integer> simple) {
        return simple.add(a, b);
    }

    public static void main(String[] args) {
        SimpleTest test = new SimpleTest();
        Integer result = test.mathAdd(3, 4, (a, b) -> a + b);
        System.out.println(result);
    }
}
