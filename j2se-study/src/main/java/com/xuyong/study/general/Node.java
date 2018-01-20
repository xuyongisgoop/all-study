package com.xuyong.study.general;

/**
 * Created by xuyong on 2018/1/17.
 */
public abstract class Node<T> {

    private T data;

    public Node(T data) {
        this.data = data;
    }

    public abstract void setData(T data);
}
