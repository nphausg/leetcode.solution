package com.nphausg.leetcode.medium;


import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/permutations">46. Permutations</a>
 */
@RunWith(Enclosed.class)
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    // Backtracking function to generate permutations
    public static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // If the current permutation is of the same length as the input, add it to the result
        if (current.size() == nums.length) {
            result.add((new ArrayList<>(current)));
            return;
        }
        // Iterate through the numbers and create permutations
        for (int num : nums) {
            // Skip if the number is already in the current permutation
            if (current.contains(num)) {
                continue;
            }
            // Add the number to the current permutation
            current.add(num);
            // Recurse to build the next permutation
            backtrack(nums, current, result);
            // Backtrack: remove the last added element to try the next number
            current.remove(current.size() - 1);
        }
    }

    public static class TestCases extends BaseTest {

        @org.junit.Test
        public void testCases() {
            ArrayList<List<Integer>> result = new ArrayList<>();
            ArrayList l1 = new ArrayList<>();
            l1.add(0);
            l1.add(1);
            ArrayList l2 = new ArrayList<>();
            l2.add(1);
            l2.add(0);
            result.add(l1);
            result.add(l2);
            assertEquals(result, permute(new int[]{0, 1}));

            // 1. [1,2,3]
            // --> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
            // 2. [0,1]
            // [[0,1],[1,0]]
            // 3. [1]
            // [[1]]
        }
    }
}
