package com.xuyong.study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	private static String REGEX = "a*b";
	private static String INPUT = "aabfooaabfooabfoobjjjj";
	private static String REPLACE = "-";

	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		// ��ȡ matcher ����
		Matcher m = p.matcher(INPUT);
		
		// ����find��group
		while (m.find()) {
			System.out.println(m.groupCount());
			System.out.println(m.group(0));
			System.out.println(m.group());
			System.out.println(m.start());
			System.out.println(m.end());
		}

		// ����matches��lookingAt
		// System.out.println(m.matches());
		// System.out.println(m.lookingAt());

		// ����replaceAll��replaceFirst
		// String replaceAll = m.replaceAll(REPLACE);
		// String replaceFirst = m.replaceFirst(REPLACE);
		// System.out.println(replaceAll);
		// System.out.println(replaceFirst);

		// ����appendRelacement��appendTail
		// StringBuffer sb = new StringBuffer();
		// while (m.find()) {
		// m.appendReplacement(sb, REPLACE);
		// }
		// m.appendTail(sb);
		// System.out.println(sb.toString());
	}
}
