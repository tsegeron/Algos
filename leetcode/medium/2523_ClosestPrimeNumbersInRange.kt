/*
    Math, Number Theory
    2523. Closest Prime Numbers in Range
    https://leetcode.com/problems/closest-prime-numbers-in-range/description/
 */

package leetcode.medium

import kotlin.math.sqrt

private fun closestPrimes(left: Int, right: Int): IntArray {
    fun Int.isPrime(): Boolean {
        if (this < 2)
            return false
        for (i in 2..(sqrt(this.toFloat())).toInt()) {
            if (this % i == 0)
                return false
        }
        return true
    }

    val res = intArrayOf(-1, -1)
    var lastPrime = 0
    var minDiff = Int.MAX_VALUE
    for (num in left..right) {
        if (num.isPrime()) {
            if (lastPrime != 0 && num - lastPrime < minDiff) {
                res[0] = lastPrime
                res[1] = num
                minDiff = num - lastPrime
            }
            lastPrime = num
        }
    }
    return res
}

fun main() {
    println(closestPrimes(1, 1000).toList())
}
