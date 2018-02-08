package com.xuyong.study.concurrent.threadlocal;

/**
 * Created by xuyong on 2018/2/3.
 */
public class TestMain {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        new Thread(() -> {
            myTask.process();
        }).start();

        new Thread(() -> {
            myTask.process();
        }).start();
    }
}
