package com.xuyong.study.time;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by xuyong on 2018/5/23.
 */
public class LocalTimeTest {

    public static void main(String[] args) {
        Date billMonthDate = getBillMonthDate(LocalDateTime.now());
        System.out.println(billMonthDate.toString());
    }

    private static Date getBillMonthDate(LocalDateTime now) {
        LocalDateTime localDateTime = now.minusMonths(1).withDayOfMonth(1).withHour(23).withMinute(59).withSecond(59).withNano(0);
        return new Date(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }
}
