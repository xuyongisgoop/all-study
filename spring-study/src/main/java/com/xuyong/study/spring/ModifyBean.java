package com.xuyong.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ModifyBean {
	
	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
		System.out.println("init bean");
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		SpringUtils spUtils = (SpringUtils)ac.getBean("springUtils");
		TestBean tb = (TestBean)spUtils.getBean("testBean");
		System.out.println(tb.getName());
		System.out.println(tb.getAge());
		tb.setName("lisi");
		tb.setAge(29);
		TestBean tb1 = (TestBean)spUtils.getBean("testBean");
		System.out.println(tb1.getName());
		System.out.println(tb1.getAge());
	}
}
