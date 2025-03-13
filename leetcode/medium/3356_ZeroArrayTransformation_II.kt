/*
    Array, Binary Search, Prefix Sum
    3356. Zero Array Transformation II
    https://leetcode.com/problems/zero-array-transformation-ii/description/
 */

package leetcode.medium

private fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
    if (nums.all { it == 0 }) return 0

    var l = 0
    var r = queries.size - 1
    var res = -1
    while (l <= r) {
        val mid = (l + r) / 2

        val maxDiff = IntArray(nums.size + 1)
        for (i in 0..mid) {
            val (ql, qr, qdif) = queries[i]
            maxDiff[ql] += qdif
            maxDiff[qr + 1] -= qdif
        }

        var prefSum = 0
        var increaseK = false
        for (i in nums.indices) {
            prefSum += maxDiff[i]
            if (prefSum < nums[i]) {
                increaseK = true
                break
            }
        }

        if (increaseK)
            l = mid + 1
        else {
            res = mid + 1
            r = mid - 1
        }
    }

    return res
}
