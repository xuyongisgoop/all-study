package com.xuyong.study.pattern.factory;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/17
 **/
public interface ICarFactory {

    /**
     * @Description: 创建汽油车
     * @Date: 2022/6/17
     **/
    Car createOilCar();

    /**
     * @Description: 创建电动车
     * @Date: 2022/6/19
     **/
    Car createModelCar();

}
