package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">714. Best Time to Buy and Sell Stock with Transaction Fee</a>
 */
@RunWith(Enclosed.class)
public class BuyAndSellStockFee {

    public static int maxProfit(int[] prices, int fee) {
        int hold = -prices[0]; // Initial state for holding a stock
        int notHold = 0;       // Initial state for not holding a stock

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, prevHold + prices[i] - fee);
        }

        return notHold;
    }

    public String mergeAlternately(String word1, String word2) {
        final int n = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        return sb.append(word1.substring(n)).append(word2.substring(n)).toString();
    }

    public static int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] notHold = new int[n];
        hold[0] = -prices[0];
        notHold[0] = 0;
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i]);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return notHold[n - 1];
    }

    public static class TestCases extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(8, maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
            assertEquals(6, maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
        }
    }
}
