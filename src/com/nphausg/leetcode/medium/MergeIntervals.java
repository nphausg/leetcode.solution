package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/merge-intervals">56. Merge Intervals</a>
 */
@RunWith(Enclosed.class)
public class MergeIntervals {

    // In-place merging O(nlogn)
    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start value
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int index = 0;
        // Tracks position of merged intervals
        for (int i = 1; i < intervals.length; i++) {
            // If no overlap, move to next interval
            if (intervals[index][1] < intervals[i][0]) {
                index++;
                intervals[index] = intervals[i];
            } else {
                // Merge intervals
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            }
        }
        return Arrays.copyOfRange(intervals, 0, index + 1);
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            System.out.println(Arrays.toString(merge(new int[][]{{1, 3}})));
            System.out.println(Arrays.toString(merge(new int[][]{{4, 5}, {1, 4}})));
            System.out.println(Arrays.toString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        }
    }
}
