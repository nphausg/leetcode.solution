package com.nphausg.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-k-closest-elements">658. Find K Closest Elements</a>
 */
public class LC0658FindClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++)
            result.add(arr[i]);
        return result;
    }
}
