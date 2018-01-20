package com.xuyong.study.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGeneral {

	public static void main(String[] args) {
//		MyStudent<String> my = new MyStudent<String>();
//		my.printName("hello you");
//		MyAnother mya = new MyAnother();
//		mya.printAnother(1111);
//		MyNode myNode = new MyNode(1);
//		System.out.println(myNode.getClass().getGenericSuperclass().getTypeName());
//		ParameterizedType genericSuperclass = (ParameterizedType) myNode.getClass().getGenericSuperclass();
//		Class<?> aClass = (Class<?>) genericSuperclass.getActualTypeArguments()[0];
//		System.out.println(aClass.getName());
		Map<String,Map<String,Object>> map =null;
		Object oo= new HashMap<String,Map<String,Object>>();
		map = (Map<String,Map<String,Object>> )oo;
	}
	
}

class Persion {

}

class Student extends Persion {

}

class Xuyong extends Student {

}
