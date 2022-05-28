package com.xuyong.study.model;

/**
 * Created by xuyong on 2022/3/7
 */
public class Car {
    private String name;
    private SmallCar smallCar;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SmallCar getSmallCar() {
        return smallCar;
    }

    public void setSmallCar(SmallCar smallCar) {
        this.smallCar = smallCar;
    }
}
