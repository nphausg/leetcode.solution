/**
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */
package com.nphausg.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. Find K Closest Elements
 * <a href="https://leetcode.com/problems/find-k-closest-elements/">...</a>
 */
public class FindClosestElements {
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