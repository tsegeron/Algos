/*
    Array, Greedy, Sorting, Counting Sort
    1833. Maximum Ice Cream Bars
    https://leetcode.com/problems/maximum-ice-cream-bars/description/
 */

package leetcode.medium

private class Solution {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (cost in costs) {
            if (cost > coins) continue
            min = minOf(min, cost)
            max = maxOf(min, cost)
        }
        val count = IntArray(max - min + 1)
        for (cost in costs) {
            if (cost > coins) continue
            ++count[cost - min]
        }

        var res = 0
        var left = coins
        for (i in min..max) {
            val toBuy = minOf(count[i], left / i)
            left -= toBuy * i
            if (left < 0) break
            res += toBuy
        }
        return res
    }
}
