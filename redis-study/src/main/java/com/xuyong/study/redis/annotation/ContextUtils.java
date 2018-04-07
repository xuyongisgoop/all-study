package com.xuyong.study.redis.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xuyong on 2018/2/28.
 */
public class ContextUtils {

    private static ApplicationContext applicationContext;

    private ContextUtils() {

    }

    public static synchronized ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        }
        return applicationContext;
    }

}
