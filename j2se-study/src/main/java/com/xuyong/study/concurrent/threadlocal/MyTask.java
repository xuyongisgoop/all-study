package com.xuyong.study.concurrent.threadlocal;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by xuyong on 2018/2/3.
 */
public class MyTask extends AbstrackTask {

    @Override
    void process() {
        initContext();
        IntStream.range(0, 10).forEach(index -> {
            submitTask(() -> {
                System.out.println("small task process parent");
                getCounter().increase();
                submitTask(() -> {
                    System.out.println("small task process children");
                    getCounter().increase();
                });
            });
        });
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getCounter().increase();
        System.out.println(getCounter().getCount());
        shutDown();
    }

}
