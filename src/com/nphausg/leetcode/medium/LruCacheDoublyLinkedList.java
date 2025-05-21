package com.nphausg.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">146. LRU Cache</a>
 * Fast lookup → HashMap (Easy & Clean)
 */
public class LruCacheDoublyLinkedList {
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LruCacheDoublyLinkedList(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        } else if (map.size() == capacity) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        insertToHead(node);
        map.put(key, node);
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/*
 * LRUCache cache = new LRUCache(2); // capacity = 2
 * cache.put(1, 1);
 * cache.put(2, 2);
 * System.out.println(cache.get(1)); // returns 1
 * cache.put(3, 3);                  // evicts key 2
 * System.out.println(cache.get(2)); // returns -1 (not found)
 * cache.put(4, 4);                  // evicts key 1
 * System.out.println(cache.get(1)); // returns -1
 * System.out.println(cache.get(3)); // returns 3
 * System.out.println(cache.get(4)); // returns 4
 */