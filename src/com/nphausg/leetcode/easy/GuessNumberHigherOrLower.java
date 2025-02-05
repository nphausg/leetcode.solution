package com.nphausg.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/guess-number-higher-or-lower">374. Guess Number Higher or Lower</a>
 */
public class GuessNumberHigherOrLower {
    private int guess(int n) {
        return 0;
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }
            if (res == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
