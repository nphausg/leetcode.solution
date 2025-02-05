package com.nphausg.leetcode.easy

/**
 * @see <a href="https://leetcode.com/problems/guess-number-higher-or-lower">374. Guess Number Higher or Lower</a>
 */
class GuessNumberHigherOrLowerKt {

    fun guess(i: Int): Int = 0

    fun guessNumber(n: Int): Int {
        var l = 1
        var r = n
        while (l < r) {
            val mid = l + (r - l) / 2
            val res: Int = guess(mid)
            if (res == 0) {
                return mid
            }
            if (res == -1) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return l
    }
}