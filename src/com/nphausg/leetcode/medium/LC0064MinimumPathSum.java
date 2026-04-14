package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/minimum-path-sum">64. Minimum Path Sum</a>
 */

// 64. Minimum Path Sum
@RunWith(Enclosed.class)
public class LC0064MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        return (int) minPathSum(0, 0, grid);
    }

    public static double minPathSum(int r, int c, int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0].length == 0) {
            return 0;
        }
        if (r == grid.length || c == grid[0].length) {
            return Double.POSITIVE_INFINITY;
        }
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c];
        }
        return grid[r][c] + Math.min(minPathSum(r + 1, c, grid), minPathSum(r, c + 1, grid));
    }

    public static int minPathSum2(int[][] grid) {
        return (int) minPathSum2(0, 0, grid, new HashMap<>());
    }

    public static double minPathSum2(int r, int c, int[][] grid, HashMap<List<Integer>, Double> memo) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0].length == 0) {
            return 0;
        }
        if (r == grid.length || c == grid[0].length) {
            return Double.POSITIVE_INFINITY;
        }
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c];
        }
        List<Integer> pos = List.of(r, c);
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        double result = grid[r][c] + Math.min(minPathSum2(r + 1, c, grid, memo), minPathSum2(r, c + 1, grid, memo));
        memo.put(pos, result);
        return result;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(12, minPathSum2(new int[][]{{1, 2, 3}, {4, 5, 6}}));
            assertEquals(7, minPathSum2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        }
    }
}
