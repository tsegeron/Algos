/*
    Array, Sorting, Radix Sort
    912. Sort an Array
    https://leetcode.com/problems/sort-an-array/description/
 */

package leetcode.medium

import kotlin.math.absoluteValue

private fun sortArray(nums: IntArray): IntArray {
    radixSort(nums)
    return nums
}

private fun radixSort(nums: IntArray) {
    val maxNum = nums.maxOfOrNull { it.absoluteValue } ?: return
    var exp = 1

    while (maxNum / exp > 0) {
        sortByDigit(nums, exp)
        exp *= 10
    }
}

private fun sortByDigit(nums: IntArray, exp: Int) {
    val count = IntArray(19)
    val res = IntArray(nums.size)

    for (num in nums)
        ++count[9 + num / exp % 10]

    for (i in 1..count.lastIndex)
        count[i] += count[i - 1]

    for (i in nums.indices.reversed()) {
        val digit = 9 + nums[i] / exp % 10
        res[--count[digit]] = nums[i]
    }

    for (i in nums.indices)
        nums[i] = res[i]
}

fun main() {
//    println(sortArray(intArrayOf(5,1,1,2,10,0)).toList())
    println(sortArray(intArrayOf(3,-1,-2,0, -10)).toList())
}
