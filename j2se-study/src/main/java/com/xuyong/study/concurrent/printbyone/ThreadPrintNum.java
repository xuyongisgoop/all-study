package com.xuyong.study.concurrent.printbyone;

public class ThreadPrintNum {
    public static void main(String[] args) {
        PrintController pc = new PrintController();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    pc.printA();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    pc.printB();
                }
            }
        }).start();
    }
}

class PrintController {
    private int flag;

    PrintController() {
        this.flag = 0;
    }

    synchronized void printA() {
        while (flag == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("printA,the num is" + i);
        }
        flag = 1;
        this.notify();
    }

    synchronized void printB() {
        while (flag == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("printB, the num is" + i);
        }
        flag = 0;
        this.notify();
    }
}