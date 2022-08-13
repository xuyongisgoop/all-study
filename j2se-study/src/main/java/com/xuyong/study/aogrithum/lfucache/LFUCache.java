package com.xuyong.study.aogrithum.lfucache;

import java.util.Map;

/**
 * @Description: LFU缓存
 * @Author: xuyong
 * @Date: 2022/8/2
 **/
public class LFUCache {

    int capacity;
    Map<Integer, Node> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return -1;
    }

    public void put(int key, int value) {

    }

    private class Node implements Comparable<Node>{
        private int key;
        private int value;
        private int count;
        private int time;

        public Node(int key, int value, int count, int time) {
            this.key = key;
            this.value = value;
            this.count = count;
            this.time = time;
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

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return 0;
        }
    }
}
