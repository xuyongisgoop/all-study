package com.xuyong.study.concurrent.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * Created by xuyong on 2018/2/2.
 */
public class TaskContext {
    private Counter counter = new Counter();

    public static TransmittableThreadLocal<TaskContext> local = new TransmittableThreadLocal<>();

    public static TaskContext getContext() {
        TaskContext localTaskContext = local.get();
        if (localTaskContext == null) {
            localTaskContext = new TaskContext();
            local.set(localTaskContext);
        }
        return localTaskContext;
    }

    public Counter getCounter() {
        return counter;
    }
}
