package com.xuyong.study.redis.annotation;

import org.springframework.context.ApplicationContext;

/**
 * Created by xuyong on 2018/2/14.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = ContextUtils.getInstance();
        MyService myService = classPathXmlApplicationContext.getBean("myService", MyService.class);
        myService.updatePhone();
        myService.setPhone();
    }
}
