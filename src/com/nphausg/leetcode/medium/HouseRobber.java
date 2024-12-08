package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/house-robber">198. House Robber</a>
 */
@RunWith(Enclosed.class)
public class HouseRobber {

    public static int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

    public static int rob2(int[] nums) {
        return robHelper2(nums, nums.length - 1);
    }

    private static int robHelper2(int[] nums, int i) {
        if (i < 0) return 0;
        return Math.max(robHelper2(nums, i - 2) + nums[i], robHelper2(nums, i - 1));
    }

    public static int rob3(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return robHelper3(nums, nums.length - 1, memo);
    }

    private static int robHelper3(int[] nums, int i, HashMap<Integer, Integer> memo) {
        if (i < 0) return 0;
        if (memo.containsKey(i)) return memo.get(i);
        int result = Math.max(robHelper3(nums, i - 2, memo) + nums[i], robHelper3(nums, i - 1, memo));
        memo.put(i, result);
        return result;
    }


    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
//            Example 1:
//
//            Input: nums = [1,2,3,1]
//            Output: 4
//            Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//                    Total amount you can rob = 1 + 3 = 4.

            assertEquals(4, rob3(new int[]{1, 2, 3, 1}));
//            Example 2:
//            Input: nums = [2,7,9,3,1]
//            Output: 12
//            Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//                    Total amount you can rob = 2 + 9 + 1 = 12.

            assertEquals(12, rob3(new int[]{2, 7, 9, 3, 1}));
        }
    }
}
