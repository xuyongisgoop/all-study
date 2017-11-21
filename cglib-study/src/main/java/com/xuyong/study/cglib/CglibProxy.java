package com.xuyong.study.cglib;

import java.io.Serializable;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3511731657451853609L;
	private EnhancerNew enhancer = new EnhancerNew();

	public Object getProxy(Class<?> clazz) {
		// 设置需要创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		//enhancer.setInterfaces(new Class[]{IFoo.class});
		// 通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	// 实现MethodInterceptor接口方法
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("前置代理");
		// 通过代理类调用父类中的方法
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("后置代理");
		return result;
	}
}