package com.nphausg.leetcode.hard;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-iii">Contains duplicate III</a>
 */
@RunWith(Enclosed.class)
public class ContainsDuplicate3 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff <= 0 || valueDiff < 0) return false;

        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {

            for (int value : map.keySet()) {
                if (Math.abs(value - nums[i]) <= valueDiff && Math.abs(map.get(value) - i) <= indexDiff) {
                    return true;
                }
            }

            map.put(nums[i], i);

            if (i >= indexDiff) {
                map.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }

    public static class TestCases extends BaseTest {

        @org.junit.Test
        public void testCases() {
            // Testcase 1: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0 --> True
            // Testcase 2: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3 --> False
            assertEquals(true, ContainsDuplicate3.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
            assertEquals(false, ContainsDuplicate3.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        }
    }
}
