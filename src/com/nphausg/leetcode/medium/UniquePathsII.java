package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/unique-paths-ii">62. Unique Paths</a>
 */
@RunWith(Enclosed.class)
public class UniquePathsII {

    public int uniquePathsWithObstacles1(int[][] grids) {
        return uniquePathsWithObstacles1(0, 0, grids);
    }

    public static int uniquePathsWithObstacles1(int r, int c, int[][] grids) {
        if (r == grids.length || c == grids[0].length) {
            return 0;
        }
        if (grids[r][c] == 1) {
            return 0;
        }
        if (r == grids.length - 1 && c == grids[0].length - 1) {
            return 1;
        }
        return uniquePathsWithObstacles1(r + 1, c, grids) + uniquePathsWithObstacles1(r, c + 1, grids);
    }


    public static int uniquePathsWithObstacles2(int[][] grids) {
        return uniquePathsWithObstacles2(0, 0, grids, new HashMap<>());
    }

    public static int uniquePathsWithObstacles2(int r, int c, int[][] grids, HashMap<List<Integer>, Integer> memo) {
        if (r == grids.length || c == grids[0].length) {
            return 0;
        }
        if (grids[r][c] == 1) {
            return 0;
        }
        if (r == grids.length - 1 && c == grids[0].length - 1) {
            return 1;
        }
        List<Integer> pos = List.of(r, c);

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        int result = uniquePathsWithObstacles2(r + 1, c, grids, memo) + uniquePathsWithObstacles2(r, c + 1, grids, memo);
        memo.put(pos, result);
        return result;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(1, uniquePathsWithObstacles2(new int[][]{{0, 1}, {0, 0}}));
            assertEquals(2, uniquePathsWithObstacles2(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        }
    }
}
