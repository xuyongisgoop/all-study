package com.xuyong.study.concurrent.threadlocal;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by xuyong on 2018/2/3.
 */
public class Counter {

    private AtomicLong count = new AtomicLong(0);

    public void increase() {
        count.incrementAndGet();
    }

    public AtomicLong getCount() {
        return count;
    }
}
