/*
    Array, Sliding Window, Sorting, Bucket Sort, Ordered Set
    220. Contains Duplicate III
    https://leetcode.com/problems/contains-duplicate-iii/description/
 */

package leetcode.hard

/*
    1,5,9,1,5,9   iDiff = 2; vDiff = 3

    1,5,9,1,5,9  / (vDiff + 1)
    0,1,2,0,1,2
 */
private fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    val buckets = mutableMapOf<Long, Long>()

    for (i in nums.indices) {
        if (i > indexDiff)
            buckets.remove((nums[i - indexDiff - 1] + 1_000_000_000L) / (valueDiff + 1))

        val curNum: Long = nums[i] + 1_000_000_000L // to make all nums non-negative
        val bucket: Long = curNum / (valueDiff + 1)

        if (bucket in buckets ||
            buckets.getOrDefault(bucket + 1, Int.MAX_VALUE.toLong()) - curNum <= valueDiff ||
            curNum - buckets.getOrDefault(bucket - 1, Int.MIN_VALUE.toLong()) <= valueDiff)
            return true

        buckets[bucket] = curNum
    }

    return false
}

fun main() {
    println(containsNearbyAlmostDuplicate(intArrayOf(1,2,3,1), 3, 0))
    println(containsNearbyAlmostDuplicate(intArrayOf(1,5,9,1,5,9), 2, 3))
    println(containsNearbyAlmostDuplicate(intArrayOf(1,0,1,1), 1, 2))
}
