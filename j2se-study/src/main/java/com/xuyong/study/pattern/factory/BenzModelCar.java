package com.xuyong.study.pattern.factory;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/19
 **/
public class BenzModelCar extends BenzCar {

    @Override
    protected void run() {
        System.out.println("benz model car run");
    }
}
