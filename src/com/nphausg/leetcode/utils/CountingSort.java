package com.nphausg.leetcode.utils;

import java.util.Arrays;

public class CountingSort {
    public void countingSort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int [] count = new int[max + 1];
        // 1. Count each number
        for (int num : nums) {
            count[num]++;
        }
        // 2. Build sorted array
        int index = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] -- > 0) {
                nums[index++] = i;
            }
        }
    }
}
