package com.xuyong.study.workpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by xuyong on 2018/4/7.
 */
public class SchedulerWorkPool<T> {

    private FixedSizeQueue<T> fixedSizeQueue;

    private ScheduledExecutorService scheduledExecutorService;

    public SchedulerWorkPool() {
        this.fixedSizeQueue = new FixedSizeQueue<>(1000);
        this.scheduledExecutorService = Executors.newScheduledThreadPool(10);
    }

    public void offer(T msg) {
        fixedSizeQueue.offer(msg);
    }

    public void submit(Runnable task) {
        IntStream.range(0, 9).forEach(i -> scheduledExecutorService.scheduleAtFixedRate(this::handleMsg, 1000, 1000, TimeUnit.MILLISECONDS));
    }

    public void handleMsg() {
        T poll = fixedSizeQueue.poll();
    }

}
