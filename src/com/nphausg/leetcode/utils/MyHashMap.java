package com.nphausg.leetcode.utils;

import java.util.LinkedList;

/**
 * <a href="https://medium.com/@nphausg/java-kotlin-hashmap-under-the-hood-341893fa3083">HashMap</a>
 */
public class MyHashMap<K, V> {

    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int SIZE = 16; // Default bucket size
    private LinkedList<Node>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // Update existing key
                return;
            }
        }
        // Insert new key-value pair
        bucket.add(new Node(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value; // Return value
            }
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index];
        // Remove key-value pair
        bucket.removeIf(node -> node.key.equals(key));
    }
}
