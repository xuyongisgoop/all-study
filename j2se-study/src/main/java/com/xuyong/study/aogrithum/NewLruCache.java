package com.xuyong.study.aogrithum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by xuyong on 2022/3/21
 */
public class NewLruCache {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<String, Node> cache;

    public static void main(String[] args) {
        NewLruCache newLruCache = new NewLruCache();
        newLruCache.put("key1", 1);
        newLruCache.put("key2", 2);
        newLruCache.put("key3", 3);
        newLruCache.put("key4", 4);
        newLruCache.put("key5", 5);
        newLruCache.put("key6", 6);
        newLruCache.put("key7", 7);
        System.out.println(newLruCache.get("key1"));
        System.out.println(newLruCache.get("key2"));
        System.out.println(newLruCache.get("key6"));
        System.out.println(newLruCache.get("key3"));
    }

    public NewLruCache() {
        capacity = 5;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public void put(String key, Object value) {
        Node target = cache.get(key);
        if (Objects.isNull(target)) {
            if (capacity == cache.size()) {
                cache.remove(tail.prev.key);
                // 把尾节点给去除
                removeTail();
            }
            Node node = new Node(key, value);
            // 把数据放入缓存
            cache.put(key, node);
            // 把node节点设置到头节点
            setHead(node);
        } else {
            cache.put(key, target);
            // 把target对应的节点设置为头节点
            target.prev.next = target.next;
            target.next.prev = target.prev;
            target.prev = null;
            target.next = null;
            setHead(target);
        }
    }

    public Object get(String key) {
        Node target = cache.get(key);
        if (!Objects.isNull(target)) {
            // 把target对应的节点设置为头节点
            target.prev.next = target.next;
            target.next.prev = target.prev;
            target.prev = null;
            target.next = null;
            setHead(target);
            return target.value;
        } else {
            return -1;
        }
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
        private String key;
        private Object value;
        private Node prev;
        private Node next;

        public Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
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
