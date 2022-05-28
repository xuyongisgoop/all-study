package com.xuyong.study.model;

/**
 * Created by xuyong on 2022/3/7
 */
public class CarTest {

    public static void main(String[] args) {
        SmallCar smallCar = new SmallCar();
        smallCar.setSmallCarName("smallCarName");
        Car car = new Car("Car");
        car.setSmallCar(smallCar);
        smallCar.setCar(car);
        System.out.println(car.getSmallCar().getSmallCarName());
    }

}
