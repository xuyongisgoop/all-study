package com.xuyong.study.dubbo.provider;

import com.xuyong.study.dubbo.service.DemoService;

public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		return "Hello, " + name;
	}

}
