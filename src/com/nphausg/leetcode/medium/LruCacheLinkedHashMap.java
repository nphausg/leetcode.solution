package com.nphausg.leetcode.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">146. LRU Cache</a>
 * Fast lookup → HashMap (Easy & Clean)
 */
class LruCacheLinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LruCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
