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

		DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
		String hello = demoService.sayHello("world"); // 执行远程方法

		System.out.println(hello); // 显示调用结果
	}
}
