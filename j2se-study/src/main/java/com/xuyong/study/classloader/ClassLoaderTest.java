package com.xuyong.study.classloader;


public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader myloader = new MyClassLoader();
		Thread.currentThread().setContextClassLoader(myloader);
//		try {
//			URLClassLoader urlLoader = new URLClassLoader(new URL[]{new URL("")});
//		} catch (MalformedURLException e1) {
//			e1.printStackTrace();
//		}
		Object obj = null;
		try {
			obj = myloader.loadClass("com.xuyong.study.classloader.ClassLoaderTest").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.xuyong.study.classloader.MyClassLoader);
	}

}
