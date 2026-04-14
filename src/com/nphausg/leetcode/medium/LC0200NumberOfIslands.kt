/**
 * <a href="https://leetcode.com/problems/number-of-islands">200. Number of Islands</a>
 */

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for (r in grid.indices){
            for (c in grid[0].indices){
                if(grid[r][c] == '1'){
                    count ++
                    dfs(grid, r, c)
                }
            }
        }
        return count
    }

    fun dfs (grid: Array<CharArray>, r : Int, c : Int){
        val rows = grid.size
        val cols = grid[0].size
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0'){
            return
        }

        grid[r][c] = '0'

        dfs (grid, r + 1, c)
        dfs (grid, r - 1, c)
        dfs (grid, r, c + 1)
        dfs (grid, r, c - 1)
    }
}