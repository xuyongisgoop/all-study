package com.xuyong.study.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuyong on 2018/1/27.
 */
public class FlatMapTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "World");
        strings.stream().map(msg -> msg.split("")).flatMap(Arrays::stream).forEach(item -> System.out.println(item));
    }
}
