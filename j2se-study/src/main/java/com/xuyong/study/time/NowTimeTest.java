package com.xuyong.study.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by xuyong on 2021/8/26
 */
public class NowTimeTest {

    public static void main(String[] args) throws ParseException {
        System.out.println(new Date());
        System.out.println(new Date().toGMTString());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String gmt = dateFormat.format(new Date()) + "Z";
        System.out.println("格林威治时间为：" + gmt);

        System.out.println(Double.valueOf(String.format("%.2f", Double.valueOf("99.678323223"))));
        System.out.println(Double.valueOf("2.448275862"));

        double percent = (Double.parseDouble(String.valueOf(Math.abs(14 - 1))) / Double.parseDouble(String.valueOf(14))) * 100;
        Double aDouble = Double.valueOf(String.format("%.2f", percent));
        System.out.println(5 > aDouble);

        System.out.println(getDateFormatToFrontDay("2017-01-01"));

    }


    public static String getDateFormatToFrontDay(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        calendar.add(Calendar.DATE, -1);
        return sdf.format(calendar.getTime());
    }
}
