/*
    Array, Binary Search
    2560. House Robber IV
    https://leetcode.com/problems/house-robber-iv/description/
 */

package leetcode.medium

private fun isValid(nums: IntArray, mid: Int, k: Int): Boolean {
    var count = 0

    var i = 0
    while (i < nums.size && count < k) {
        if (nums[i] <= mid) {
            ++count
            ++i
        }
        ++i
    }
    return count >= k
}

private fun minCapability(nums: IntArray, k: Int): Int {
    var (min, max) = 1 to nums.max()

    while (min < max) {
        val mid = (min + max) / 2

        if (isValid(nums, mid, k))
            max = mid
        else
            min = mid + 1
    }

    return min
}
