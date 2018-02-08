package com.xuyong.study.concurrent.threadlocal;

import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xuyong on 2018/2/3.
 */
public abstract class AbstrackTask {

    private ExecutorService executor;

    public AbstrackTask() {
        executor = Executors.newFixedThreadPool(5);
    }

    abstract void process();

    protected void submitTask(Runnable runnable) {
        TtlRunnable ttlRunnable = TtlRunnable.get(runnable);
        CompletableFuture.runAsync(() -> ttlRunnable.run(), executor);
    }

    protected void shutDown() {
        executor.shutdown();
    }

    protected Counter getCounter() {
        return TaskContext.getContext().getCounter();
    }

    protected void initContext() {
        TaskContext.getContext();
    }

}
