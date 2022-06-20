package com.xuyong.study.service;

import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/20
 **/
@Service
public class JindongBuyService implements BuyService {

    @Override
    public void goShopping() {
        System.out.println("begin shopping in jindong");
    }

    @Override
    public boolean match(String factor) {
        return factor.equals("jd");
    }

}
