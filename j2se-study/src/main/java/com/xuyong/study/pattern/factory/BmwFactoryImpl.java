package com.xuyong.study.pattern.factory;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/18
 **/
public class BmwFactoryImpl implements ICarFactory {

    @Override
    public Car createOilCar() {
        return new BmwOilCar();
    }

    @Override
    public Car createModelCar() {
        return new BmwModelCar();
    }

}
