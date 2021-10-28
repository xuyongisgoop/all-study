package com.xuyong.study.regex;

import java.util.regex.Pattern;

/**
 * Created by xuyong on 2019/4/22
 */
public class MatchTest {

    public static void main(String[] args) {
        boolean matches = Pattern.compile("[+-]?(((\\d|[1-8]\\d)\\.\\d*)|90(\\.0*)?)").matcher("119.94521070157")
                                 .matches();
        System.out.println(matches);
    }

}
