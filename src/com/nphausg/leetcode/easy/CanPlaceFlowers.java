package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * <a href="https://leetcode.com/problems/can-place-flowers">605. Can Place Flowers</a>
 */
@RunWith(Enclosed.class)
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean prevEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean nextEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
                if (prevEmpty && nextEmpty) {
                    flowerbed[i] = 1;  // Trồng hoa vào ô đất này
                    count++;
                }
            }
            if (count >= n) {
                return true;
            }
        }
        return false;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {

        }
    }
}
