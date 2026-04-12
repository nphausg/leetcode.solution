class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        for (stone in stones){
            maxHeap.add(stone)
        }

        while(maxHeap.size > 1){
            val s1 = maxHeap.poll()
            val s2 = maxHeap.poll()
            if(s1 != s2){
                maxHeap.add(s1 - s2)
            }
        }
        return if (maxHeap.isEmpty()) 0 else maxHeap.peek()
    }
}