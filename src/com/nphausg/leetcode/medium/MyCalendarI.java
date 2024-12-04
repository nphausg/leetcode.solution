package com.nphausg.leetcode.medium;

import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/my-calendar-i">729. My Calendar I</a>
 */
public class MyCalendarI {

    private final TreeMap<Integer, Integer> calendar;

    public MyCalendarI() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((prev != null && calendar.get(prev) > start) || (next != null && next < end)) {
            return false; // Overlap detected
        }
        calendar.put(start, end);
        return true; // Successfully booked
    }
}
