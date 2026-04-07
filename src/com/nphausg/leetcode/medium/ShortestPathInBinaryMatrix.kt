class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val n = grid.size
        
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1

        if (n == 1)
            return 1

        var count = 1
        val directions = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(-1, 0),
            intArrayOf(-1, 1),
            intArrayOf(0, -1),
            intArrayOf(0, 1),
            intArrayOf(1, -1),
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        )

        val queue = ArrayDeque<Pair<Int,Int>>()
        queue.add(Pair(0,0))

        while (queue.isNotEmpty()){
            val size = queue.size
            for (i in 0 until size){
                val (r, c) = queue.removeFirst()
                if( r == n - 1 && c == n - 1)
                    return count
                for (d in directions){
                    val nr = r + d[0]
                    val nc = c + d[1]
                    if(nr in 0 until n && nc in 0 until n && grid[nr][nc] == 0){
                        queue.add(Pair(nr, nc))
                        grid[nr][nc] = 1
                    }
                }
            }
            count++
        }
        return -1
    }
}