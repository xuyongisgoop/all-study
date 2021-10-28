package com.xuyong.study.aogrithum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyong on 2021/2/4
 */
public class LruCache {
    private int capacity = 4;
    private Node head;
    private Node tail;
    private Map<String, Node> cache = new HashMap<>();

    public static void main(String[] args) {
        LruCache lruCache = new LruCache();
        lruCache.put("key1", 1);
        lruCache.put("key2", 2);
        lruCache.put("key3", 3);
        lruCache.put("key4", 4);
        lruCache.put("key5", 5);
        lruCache.put("key2", 2);
        System.out.println("result: " + lruCache.get("key1"));
    }

    public LruCache() {
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public void put(String key, Integer value) {
        Node node = cache.get(key);
        if (node == null) {
            // 判断是否已经达到缓存上限
            if (cache.size() == capacity) {
                // 将相应的缓存删除
                cache.remove(tail.prev.key);
                // 将链表尾部的删除
                delTailNode();
            }
            node = new Node(key, value);
            cache.put(key, node);
        } else {
            // 把原先位置的截断
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        // 把设置的元素放在链表头
        setHeadNode(node);
    }

    public Integer get(String key) {
        Node node = cache.get(key);
        if (node == null) {
            return null;
        } else {
            // 把原先位置的截断
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 把被访问的元素设置在链表头
            setHeadNode(node);
            return node.value;
        }
    }

    private void setHeadNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void delTailNode() {
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
    }

    public class Node {
        private String key;
        private Integer value;
        private Node prev;
        private Node next;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
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
