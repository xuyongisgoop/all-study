package com.xuyong.study.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/21
 **/
@Service
public class LifeCycleService implements ApplicationContextAware {

    @PostConstruct
    public void init() {
        System.out.println("LifeCycleService init");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("LifeCycleService setApplicationContext");
    }
}
