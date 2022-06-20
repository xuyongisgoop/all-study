package com.xuyong.study.pattern.factory;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/17
 **/
public class FactoryTest {

    public static void main(String[] args) {
        ICarFactory benzFactory = new BenzFactoryImpl();
        Car benzOilCar = benzFactory.createOilCar();
        benzOilCar.run();
        Car benzModelCar = benzFactory.createModelCar();
        benzModelCar.run();
        ICarFactory bmwFactory = new BmwFactoryImpl();
        Car bmwOilCar = bmwFactory.createOilCar();
        bmwOilCar.run();
        Car bmwModelCar = bmwFactory.createModelCar();
        bmwModelCar.run();
    }

}
