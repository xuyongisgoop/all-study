package com.xuyong.study.pattern.factory;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/19
 **/
public class BenzOilCar extends BenzCar {

    @Override
    protected void run() {
        System.out.println("benz oil car run");;
    }

}
