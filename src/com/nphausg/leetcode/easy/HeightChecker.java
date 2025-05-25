package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/height-checker">1051. Height Checker</a>
 */
@RunWith(Enclosed.class)
public class HeightChecker {

    public static int heightChecker(int[] heights) {
        int ans = 0;
        int currentHeight = 1;
        int[] count = new int[101];
        for (int height : heights) {
            ++count[height];
        }
        for (int height : heights) {
            while (count[currentHeight] == 0) {
                ++currentHeight;
            }
            if (height != currentHeight) {
                ++ans;
            }
            --count[currentHeight];
        }
        return ans;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(3, heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
            assertEquals(5, heightChecker(new int[]{5, 1, 2, 3, 4}));
            assertEquals(0, heightChecker(new int[]{1, 2, 3, 4, 5}));
        }
    }
}
