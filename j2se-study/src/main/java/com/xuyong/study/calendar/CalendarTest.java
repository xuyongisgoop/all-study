package com.xuyong.study.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		printCalender(date);
		sc.close();
	}
	
	public static void printCalender(Date date) {
		System.out.println("日	一	二	三	四	五	六	");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int recentDate = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, 1);
		for (int i = Calendar.SUNDAY; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			calendar.set(Calendar.DATE, i);
			if (recentDate == i) {
				System.out.print(i + "*\t");
			} else {
				System.out.print(i + "\t");
			}
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				System.out.println();
			}
		}
	}
	
}
