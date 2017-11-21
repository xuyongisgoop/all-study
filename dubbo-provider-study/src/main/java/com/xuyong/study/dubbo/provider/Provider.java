package com.xuyong.study.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "provider.xml" });
		System.out.println("ready.....");
		context.start();
		
		System.in.read(); // 按任意键退出
	}
}
