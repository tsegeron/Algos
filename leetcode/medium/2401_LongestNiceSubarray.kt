/*
    Array, Bit Manipulation, Sliding Window
    2401. Longest Nice Subarray
    https://leetcode.com/problems/longest-nice-subarray/description/
 */

package leetcode.medium

private fun longestNiceSubarray(nums: IntArray): Int {
    var maxLen = 1

    var curXor = 0
    var l = 0
    for (i in nums.indices) {
        while (curXor and nums[i] != 0)
            curXor = curXor xor nums[l++]

        curXor = curXor xor nums[i]
        maxLen = maxOf(maxLen, i - l + 1)
    }

    return maxLen
}
