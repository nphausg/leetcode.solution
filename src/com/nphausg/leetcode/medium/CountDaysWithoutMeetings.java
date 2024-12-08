package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/count-days-without-meetings">3169. Count Days Without Meetings</a>
 */
@RunWith(Enclosed.class)
public class CountDaysWithoutMeetings {

    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int totalMeetingDays = 0;
        int prevStart = -1, prevEnd = -1;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (prevEnd < start) {
                if (prevStart != -1) {
                    totalMeetingDays += prevEnd - prevStart + 1;
                }
                prevStart = start;
                prevEnd = end;
            } else {
                prevEnd = Math.max(prevEnd, end);
            }
        }

        if (prevStart != -1) {
            totalMeetingDays += prevEnd - prevStart + 1;
        }

        return days - totalMeetingDays;
    }

    // Memory Limit Exceeded
    public static int countDays3(int days, int[][] meetings) {
        int[] status = new int[days + 2];

        for (int[] meeting : meetings) {
            status[meeting[0]]++;
            status[meeting[1] + 1]--;
        }

        int activeMeetings = 0;
        int noMeetingDays = 0;

        for (int day = 1; day <= days; day++) {
            activeMeetings += status[day];
            if (activeMeetings == 0) {
                noMeetingDays++;
            }
        }

        return noMeetingDays;
    }


    // Time Limit Exceeded
    public static int countDays2(int days, int[][] meetings) {
        List<int[]> events = new ArrayList<>();
        for (int[] meeting : meetings) {
            events.add(new int[]{meeting[0], 1});
            events.add(new int[]{meeting[1] + 1, -1});
        }

        events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int activeMeetings = 0;
        int prevDay = 1; // Bắt đầu từ ngày 1
        int noMeetingDays = 0;

        for (int[] event : events) {
            int currentDay = event[0];

            if (activeMeetings == 0 && prevDay < currentDay) {
                noMeetingDays += currentDay - prevDay;
            }

            activeMeetings += event[1];
            prevDay = currentDay;
        }

        if (prevDay <= days && activeMeetings == 0) {
            noMeetingDays += days - prevDay + 1;
        }

        return noMeetingDays;
    }


    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
//            Example 1:
//
//            Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
//
//            Output: 2
//
//            Explanation:
//
//            There is no meeting scheduled on the 4th and 8th days.
//
            assertEquals(2, countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}}));
//            Example 2:
//
//            Input: days = 5, meetings = [[2,4],[1,3]]
//
//            Output: 1
//
//            Explanation:
//
//            There is no meeting scheduled on the 5th day.

            // assertEquals(1, countDays(5, new int[][]{{2, 4}, {1, 3}}));

//            Example 3:
//
//            Input: days = 6, meetings = [[1,6]]
//
//            Output: 0
//
//            Explanation:
//
//            Meetings are scheduled for all working days.

            // assertEquals(0, countDays(6, new int[][]{{1, 6}}));
        }
    }
}
