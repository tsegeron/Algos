package leetcode.easy

private fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var buy = Int.MAX_VALUE

    for (price in prices) {
        if (price < buy)
            buy = price
        else if (price - buy > maxProfit)
            maxProfit = price - buy
    }

    return maxProfit
}
