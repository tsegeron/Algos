/*
    Array, Sorting, Bucket Sort, Radix Sort
    164. Maximum Gap
    https://leetcode.com/problems/maximum-gap/description/
 */

package leetcode.medium

private fun maximumGap(nums: IntArray): Int {
    if (nums.size < 2) return 0

    radixSort(nums)

    var maxGap = 0
    for (i in 1..nums.lastIndex)
        maxGap = maxOf(maxGap, nums[i] - nums[i - 1])

    return maxGap
}

private fun radixSort(nums: IntArray) {
    val maxNum = nums.maxOrNull() ?: return
    var exp = 1

    while (maxNum / exp != 0) {
        sortByDigit(nums, exp)
        exp *= 10
    }
}

private fun sortByDigit(nums: IntArray, exp: Int) {
    val count = IntArray(10)
    val res = IntArray(nums.size)

    for (num in nums)
        ++count[num / exp % 10]

    for (i in 1..count.lastIndex)
        count[i] += count[i - 1]

    for (i in nums.indices.reversed()) {
        val digit = nums[i] / exp % 10
        res[--count[digit]] = nums[i]
    }

    for (i in nums.indices)
        nums[i] = res[i]
}
