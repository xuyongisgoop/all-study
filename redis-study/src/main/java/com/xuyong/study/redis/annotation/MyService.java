package com.xuyong.study.redis.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by xuyong on 2018/2/14.
 */
@Service
public class MyService {

    public void updatePhone() {
        privateUpdatePhone();
        System.out.println("begin update phone");
    }

    @CacheDel(key = "")
    private void privateUpdatePhone() {
        System.out.println("private update phone");
    }

    @CacheSet(key = "")
    public String setPhone() {
        System.out.println("begin set phone");
        String newPhone = "18019289387";
        return newPhone;
    }

}
