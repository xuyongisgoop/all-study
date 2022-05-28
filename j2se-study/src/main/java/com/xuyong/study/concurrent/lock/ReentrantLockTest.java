package com.xuyong.study.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuyong on 2022/3/8
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {

        } finally {
            reentrantLock.unlock();
        }
    }

}
