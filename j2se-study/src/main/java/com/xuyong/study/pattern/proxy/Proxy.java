package com.xuyong.study.pattern.proxy;

public class Proxy {

    public static void main(String[] args) {
        Man liuxiang = new Liuxiang();
        Man jingjiren = new Jingjiren(liuxiang);
        jingjiren.quickRun();
    }
}
