package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum">39. Combination Sum</a>
 * Return an array containing any combination of elements that add up to
 * exactly the targetSum.
 * - If there is no combination that adds up to the targetSum, then return null.
 * - If there are multiple combinations possible, you may return any single one.
 */

@RunWith(Enclosed.class)
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int target, int[] candidates) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        // Base case: if the target becomes 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(path));  // Add a copy of path to result
            return;
        }

        // If the target is negative, there's no point in continuing down this path
        if (target < 0) {
            return;
        }

        // Loop through all candidates starting from the current index
        for (int i = start; i < candidates.length; i++) {
            // Add the candidate to the current path
            path.add(candidates[i]);

            // Recur with the updated target (target - candidates[i])
            // We pass `i` as the start because we can reuse the same candidate
            backtrack(candidates, target - candidates[i], i, path, result);

            // Backtrack: remove the last added candidate to explore the next option
            path.remove(path.size() - 1);
        }
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void test() {
            System.out.println(combinationSum(5, new int[]{2, 3}));
            System.out.println(combinationSum(7, new int[]{2, 3}));
            System.out.println(combinationSum(8, new int[]{2, 3, 5}));
            System.out.println(combinationSum(7, new int[]{5, 3, 4, 7}));
            System.out.println(combinationSum(300, new int[]{7, 14}));
        }
    }
}
