package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/teemo-attacking">495. Teemo Attacking</a>
 */
public class TeemoAttacking {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;
        int totalTime = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            totalTime += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        totalTime += duration;
        return totalTime;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {

//            Example 1:
//
//            Input: timeSeries = [1,4], duration = 2
//            Output: 4
//            Explanation: Teemo's attacks on Ashe go as follows:
//                    - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
//                    - At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
//            Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.
//                    Example 2:

            assertEquals(4, findPoisonedDuration(new int[]{1, 4}, 2));
//            Input: timeSeries = [1,2], duration = 2
//            Output: 3
//            Explanation: Teemo's attacks on Ashe go as follows:
//                    - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
//                    - At second 2 however, Teemo attacks again and resets the poison timer. Ashe is poisoned for seconds 2 and 3.
//            Ashe is poisoned for seconds 1, 2, and 3, which is 3 seconds in total.
            assertEquals(3, findPoisonedDuration(new int[]{1, 2}, 2));
            assertEquals(9, findPoisonedDuration(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1));
        }
    }
}
