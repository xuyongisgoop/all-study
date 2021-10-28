package com.xuyong.study.pattern.proxy;

/**
 * Created by xuyong on 2019/6/18
 */
public class Jingjiren implements Man{

    private Man man;

    public Jingjiren(Man man) {
        this.man = man;
    }

    @Override
    public void quickRun() {
        System.out.println("jingjiren say : let liuxiang run");
        man.quickRun();
    }
}
