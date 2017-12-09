package com.xuyong.study.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xuyong.study.dubbo.service.DemoService;

public class Consumer {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("test111");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "consumer.xml" });
		context.start();
		System.out.println("begin consumer ....");

		DemoService demoService = (DemoService) context.getBean("demoService");
		String hello = demoService.sayHello("world");

		System.out.println(hello);
	}
}
