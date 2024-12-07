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
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int index = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] < intervals[i][0]) {
                index++;
                intervals[index] = intervals[i];
            } else {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            }
        }
        return Arrays.copyOfRange(intervals, 0, index + 1);
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            merge(new int[][]{{1, 3}});
//            Example 1:
//
//            Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//            Output: [[1,6],[8,10],[15,18]]
//            Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
            merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
//            Example 2:
//
//            Input: intervals = [[1,4],[4,5]]
//            Output: [[1,5]]
//            Explanation: Intervals [1,4] and [4,5] are considered overlapping.
            merge(new int[][]{{4, 5}, {1, 4}});
        }
    }
}
