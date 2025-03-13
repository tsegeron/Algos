/*
    Array, Prefix Sum
    3355. Zero Array Transformation I
    https://leetcode.com/problems/zero-array-transformation-i/description/
 */

package leetcode.medium

private fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
    val maxDiff = IntArray(nums.size + 1)

    for ((l, r) in queries) {
        ++maxDiff[l]
        --maxDiff[r + 1]
    }

    var prefSum = 0
    for (i in nums.indices) {
        prefSum += maxDiff[i]
        if (prefSum < nums[i])
            return false
    }
    return true
}
