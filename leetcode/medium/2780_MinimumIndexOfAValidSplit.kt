/*
    Array, Hash Table, Sorting
    2780. Minimum Index of a Valid Split
    https://leetcode.com/problems/minimum-index-of-a-valid-split/description/
 */

package leetcode.medium

private class Solution2780 {
    fun minimumIndex(nums: List<Int>): Int {
        val count = mutableMapOf<Int, Int>()
        var mostFrequent = Pair(0, 0)
        for (num in nums) {
            count.compute(num) { _, c -> c?.inc() ?: 1 }
            if (count[num]!! > mostFrequent.second)
                mostFrequent = num to count[num]!!
        }

        if (mostFrequent.second <= (nums.size + 1) / 2)
            return -1

        var mfCount = 0
        for (i in nums.indices) {
            if (nums[i] == mostFrequent.first)
                ++mfCount
            if (mfCount > (i + 1) / 2)
                return i
        }

        return -1
    }
}
