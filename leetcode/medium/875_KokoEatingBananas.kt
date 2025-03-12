/*
    Array, Binary Search
    875. Koko Eating Bananas
    https://leetcode.com/problems/koko-eating-bananas/description/
 */

package leetcode.medium

private fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var min = 1
    var max = 1_000_000_000

    var mid = 1
    val foo = { a: Int, n: Int -> if (a > h) Int.MAX_VALUE else a + n / mid + (n % mid != 0).compareTo(false) }

    var res = 0
    while (min <= max) {
        mid = min + (max - min) / 2
        if (piles.fold(0, foo) > h)
            min = mid + 1
        else
            res = mid.also { max = mid - 1 }
    }

    return res
}

fun main() {
    println(minEatingSpeed(intArrayOf(312884470), 968709470))
    println(minEatingSpeed(intArrayOf(3,6,7,11), 8))
    println(minEatingSpeed(intArrayOf(30,11,23,4,20), 5))
    println(minEatingSpeed(intArrayOf(30,11,23,4,20), 6))
    println(minEatingSpeed(intArrayOf(312884470), 312884469))
}
