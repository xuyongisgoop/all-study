package com.xuyong.study.calendar;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by xuyong on 2019-09-05
 */
public class TimeTest {

    public static void main(String[] args) {
        System.out.println(DateFormatUtils.format(getDayStart(), "yyyy-MM-dd HH:mm:ss"));
    }

    public static Date getDayStart() {
        long current = System.currentTimeMillis();
        long zero = (current / (1000 * 3600 * 24)) * (1000 * 3600 * 24)
                - TimeZone.getDefault().getRawOffset();
        return new Date(zero);
    }
}
