package com.xuyong.study.redis.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by xuyong on 2018/2/14.
 */
@Aspect
@Component
public class CacheAspect implements ApplicationContextAware{
    private static ApplicationContext applicationContext;

//    @Autowired
//    private RedisService redisService;
//
//    @Autowired
//    private MqService mqService;

    @Around("execution(* *(..)) && @annotation(com.xuyong.study.redis.annotation.CacheDel)")
    public Object del(ProceedingJoinPoint joinPoint) {
        RedisService redisService = (RedisService)applicationContext.getBean("redisService");
        MqService mqService = (MqService)applicationContext.getBean("mqService");
        System.out.println("cache aspect del phone");
        redisService.del();
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        mqService.sentMessage();
        return proceed;
    }

    @Around("execution(* *(..)) && @annotation(com.xuyong.study.redis.annotation.CacheSet)")
    public Object set(ProceedingJoinPoint joinPoint) {
        System.out.println("cache aspect set phone");
        RedisService redisService = (RedisService)applicationContext.getBean("redisService");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        redisService.set();
        return proceed;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
