package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii">122. Best Time to Buy and Sell Stock II</a>
 */
@RunWith(Enclosed.class)
public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int resting = 0;          // Maximum profit when not holding stock
        int holding = -prices[0]; // Maximum profit when holding stock

        for (int i = 1; i < prices.length; i++) {
            int newResting = Math.max(resting, holding + prices[i]);
            holding = Math.max(holding, resting - prices[i]);
            resting = newResting;
        }

        return resting;
    }

    public static class TestCases extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));
            assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
            assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
        }
    }
}
