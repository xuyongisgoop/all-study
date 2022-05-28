package com.xuyong.study.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by xuyong on 2022/3/7
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.incrementAndGet();
        System.out.println("increase get value = " + i);

        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1, 1);
        new Thread(() -> {
            shutdownMethod();
        }).start();
        acquireQueued(2);
    }

    private static void shutdownMethod() {
        System.out.println("hello this is test method!!!");
    }

    private static boolean acquireQueued(int arg) {
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;) {
                if (arg == 1) {
                    return interrupted;
                }
                if (arg == 2) {
                    interrupted = true;
                }
            }
        } finally {
            System.out.println("finally");
        }
    }

}
