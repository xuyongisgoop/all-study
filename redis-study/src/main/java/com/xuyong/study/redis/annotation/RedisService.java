package com.xuyong.study.redis.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by xuyong on 2018/2/15.
 */
@Service
public class RedisService {

    public void set() {
        System.out.println("RedisService set value");
    }

    public void del() {
        System.out.println("RedisService del value");
    }
}
