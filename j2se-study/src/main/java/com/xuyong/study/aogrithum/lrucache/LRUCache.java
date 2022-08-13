package com.xuyong.study.aogrithum.lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: LRU缓存
 * @Author: xuyong
 * @Date: 2022/8/1
 **/
public class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(2));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (Objects.nonNull(node)) {
            resetHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (Objects.nonNull(node)) {
            resetHead(node);
        } else {
            if (cache.size() == this.capacity) {
                cache.remove(tail.prev.key);
                resetTail();
            }
            Node newNode = new Node(key, value);
            resetHead(newNode);
            cache.put(key, newNode);
        }
    }

    private void resetHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    private void resetTail() {
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    private class Node {
        private Node prev;
        private Node next;
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
