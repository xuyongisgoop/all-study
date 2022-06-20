package com.xuyong.study.pattern.factory;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/17
 **/
public class BenzFactoryImpl implements ICarFactory {

    @Override
    public Car createOilCar() {
        return new BenzOilCar();
    }

    @Override
    public Car createModelCar() {
        return new BenzModelCar();
    }

}
