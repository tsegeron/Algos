/*
    Array, Binary Search
    2594. Minimum Time to Repair Cars
    https://leetcode.com/problems/minimum-time-to-repair-cars/description/
 */

package leetcode.medium

import kotlin.math.sqrt

private fun isValid(ranks: IntArray, cars: Int, time: Long): Boolean {
    var count: Long = 0

    for (rank in ranks)
        count += sqrt((time / rank).toDouble()).toInt()

    return count >= cars
}

private fun repairCars(ranks: IntArray, cars: Int): Long {
    var l: Long = 1
    var r: Long = ranks.max().toLong() * cars * cars

    while (l < r) {
        val mid = (l + r) / 2

        if (isValid(ranks, cars, mid))
            r = mid
        else
            l = mid + 1
    }

    return l
}
