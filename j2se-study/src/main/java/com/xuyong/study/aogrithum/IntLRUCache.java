package com.xuyong.study.aogrithum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by xuyong on 2022/3/21
 */
class IntLRUCache {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;

    public static void main(String[] args) {
        IntLRUCache newLruCache = new IntLRUCache(2);
        newLruCache.put(1, 1);
        newLruCache.put(2, 2);
        newLruCache.put(3, 3);
        System.out.println(newLruCache.get(1));
        System.out.println(newLruCache.get(3));
        System.out.println(newLruCache.get(2));
        newLruCache.put(4, 4);
        System.out.println(newLruCache.get(2));
    }

    public IntLRUCache(int cap) {
        capacity = cap;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        Node target = cache.get(key);
        if (!Objects.isNull(target)) {
            // 把target对应的节点从链表中去除
            target.prev.next = target.next;
            target.next.prev = target.prev;
            // 把target对应的节点设置为头节点
            setHead(target);
            return target.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node target = cache.get(key);
        if (Objects.isNull(target)) {
            if (capacity == cache.size()) {
                cache.remove(tail.prev.key);
                // 把尾节点给去除
                removeTail();
            }
        } else {
            // 把target对应的节点从链表中去除
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        Node node = new Node(key, value);
        // 把数据放入缓存
        cache.put(key, node);
        // 把node节点设置到头节点
        setHead(node);
    }

    private void setHead(Node node) {
        Node temp = head.next;
        temp.prev = node;
        node.prev = head;
        node.next = temp;
        head.next = node;
    }

    private void removeTail() {
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    private class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
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
    }
}
