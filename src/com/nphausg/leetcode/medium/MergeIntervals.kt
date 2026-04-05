class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if( intervals.isEmpty()) return arrayOf()
        intervals.sortBy { it[0] }
        val merged = mutableListOf<IntArray>()
        var current = intervals [0]
        merged.add(current)
        for (next in intervals){
            if(next[0] <= current[1]){
                current[1] = maxOf(current[1], next[1])
            }
            else {
                current = next
                merged.add(current)
            }
        }
        return merged.toTypedArray()
    }
}