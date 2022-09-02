package com.xuyong.study.concurrent.producerconsumer;

import java.util.Random;

public class ProductorConsumerTest {
    public static void main(String[] args) {
        ProductContainer pc = new ProductContainer();
        new Thread(new Productor(pc)).start();
        new Thread(new Consumer(pc)).start();
    }
}

class Productor implements Runnable {
    private ProductContainer pc;

    Productor(ProductContainer pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            pc.push(new Random(100).nextInt());
            Thread.interrupted();
        }
    }
}

class Consumer implements Runnable {
    private ProductContainer pc;

    Consumer(ProductContainer pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            pc.pop();
            Thread.interrupted();
        }
    }
}

class ProductContainer {
    private int top;
    private int[] container;

    ProductContainer() {
        this.top = 0;
        this.container = new int[10];
    }

    synchronized boolean push(int content) {
        while (top == container.length) {
            System.out.println("容器满了");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        container[top] = content;
        top++;
        System.out.println("开始放入一个产品，有" + top + "个");
        return true;
    }

    synchronized int pop() {
        while (top == 0) {
            System.out.println("容器空了");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        top--;
        System.out.println("开始消费一个产品，现在还有" + top + "个");
        return container[top];
    }
}