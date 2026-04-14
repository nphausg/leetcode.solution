package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target">2824. Count Pairs Whose Sum is Less than Target</a>
 */

@RunWith(Enclosed.class)
public class LC2824CountPairs {

    // Binary search
    public static int countPairsBinarySearch(List<Integer> nums, int target) {
        List<Integer> list = new ArrayList<>(nums);
        Collections.sort(list);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int left = i + 1, right = list.size() - 1, lastValidIndex = i;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int sum = list.get(i) + list.get(mid);
                if (sum < target) {
                    lastValidIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            count += (lastValidIndex - i);
        }
        return count;
    }

    // 2-pointers
    public static int countPairs2Pointers(List<Integer> nums, int target) {
        List<Integer> list = new ArrayList<>(nums);
        Collections.sort(list);
        int left = 0, right = list.size() - 1, count = 0;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(3, countPairsBinarySearch(List.of(-1, 1, 2, 3, 1), 2));
            assertEquals(10, countPairsBinarySearch(List.of(-6, 2, 5, -2, -7, -1, 3), -2));
        }
    }
}
