package com.nphausg.leetcode.easy
/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">121. Best Time to Buy and Sell Stock</a>
 */

object BuyAndSellStock {

    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minPrice = Int.MAX_VALUE

        for (price in prices) {
            if (price < minPrice) {
                minPrice = price // Update the minimum price
            } else {
                val profit = price - minPrice // Calculate potential profit
                if (profit > maxProfit) {
                    maxProfit = profit // Update max profit if needed
                }
            }
        }
        return maxProfit
    }
}