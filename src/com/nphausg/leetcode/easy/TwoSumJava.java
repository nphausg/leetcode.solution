package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/two-sum">Two Sum</a>
 */
public class TwoSumJava {

    // Brute-force solution
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("[" + i + "] = " + nums[i] + " -- [" + j + "] = " + nums[j]);
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Hash-map
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (map.containsKey(delta)) {
                return new int[]{map.get(delta), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static class TwoSumTest extends BaseTest {

        @org.junit.Test
        public void testCases() {
            /*
             * Example 1:
             * Input: nums = [2,7,11,15], target = 9
             * Output: [0,1]
             * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
             */
            twoSum2(new int[]{2, 7, 11, 15}, 9);
            /*
             * Example 2:
             * Input: nums = [3, 2, 4],target = 6
             * Output: [1, 2]
             */
            //twoSum2(new int[]{3, 2, 4}, 6);
            /*
             * Example 3:
             * Input: nums = [3, 3],target = 6
             * Output: [0, 1]
             */
            // twoSum2(new int[]{3, 3}, 6);
            /*
             * Example 4:
             * Input: nums = [1, 3, 7, 9, 2],target = 11
             * Output: [3, 4]
             */
            //  twoSum2(new int[]{1, 3, 7, 9, 2}, 11);
        }
    }
}
