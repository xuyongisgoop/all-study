package com.xuyong.study.workpool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xuyong on 2018/4/7.
 */
public class FixedSizeQueue<T> {

    private LinkedBlockingQueue<T> queue;

    public FixedSizeQueue(int size) {
        this.queue = new LinkedBlockingQueue<>(size);
    }

    public void offer(T msg) {
        queue.offer(msg);
    }

    public T poll() {
        return queue.poll();
    }

}
