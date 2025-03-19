/*
    Array, Queue, Sliding Window, Heap (Priority Queue), Ordered Set, Monotonic Queue
    2762. Continuous Subarrays
    https://leetcode.com/problems/continuous-subarrays/description/
 */

package leetcode.medium

private fun continuousSubarrays(nums: IntArray): Long {
    var res = 0L
    val count = mutableMapOf<Int, Int>()

    var l = 0
    for (i in nums.indices) {
        count[nums[i]] = count.getOrDefault(nums[i], 0) + 1

        while (count.maxOf { it.key } - count.minOf { it.key } > 2) {
            if (count[nums[l]]!! == 1)
                count.remove(nums[l])
            else
                count[nums[l]] = count[nums[l]]!! - 1
            ++l
        }

        res += i - l + 1
    }

    return res
}
