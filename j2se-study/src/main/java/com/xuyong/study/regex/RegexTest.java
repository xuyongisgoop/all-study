package com.xuyong.study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	private static String REGEX = "a*b";
	private static String INPUT = "aabfooaabfooabfoobjjjj";
	private static String REPLACE = "-";

	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		// 获取 matcher 对象
		Matcher m = p.matcher(INPUT);
		
		// 测试find和group
		while (m.find()) {
			System.out.println(m.groupCount());
			System.out.println(m.group(0));
			System.out.println(m.group());
			System.out.println(m.start());
			System.out.println(m.end());
		}

		// 测试matches和lookingAt
		// System.out.println(m.matches());
		// System.out.println(m.lookingAt());

		// 测试replaceAll和replaceFirst
		// String replaceAll = m.replaceAll(REPLACE);
		// String replaceFirst = m.replaceFirst(REPLACE);
		// System.out.println(replaceAll);
		// System.out.println(replaceFirst);

		// 测试appendRelacement和appendTail
		// StringBuffer sb = new StringBuffer();
		// while (m.find()) {
		// m.appendReplacement(sb, REPLACE);
		// }
		// m.appendTail(sb);
		// System.out.println(sb.toString());
	}
}
