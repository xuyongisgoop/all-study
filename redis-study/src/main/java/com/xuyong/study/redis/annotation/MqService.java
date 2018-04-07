package com.xuyong.study.redis.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by xuyong on 2018/2/15.
 */
@Service
public class MqService {

    public void sentMessage() {
        System.out.println("MqService send message");
    }
}
