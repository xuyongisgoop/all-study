package com.xuyong.study.pattern.factory;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/19
 **/
public class BmwModelCar extends BmwCar {

    @Override
    protected void run() {
        System.out.println("bmw model car run");
    }

}
