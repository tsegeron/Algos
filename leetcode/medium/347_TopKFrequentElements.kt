/*
    Medium
    347. Top K Frequent Elements
    https://leetcode.com/problems/top-k-frequent-elements/description/
 */

package leetcode.medium

private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    nums.forEach { map[it] = map.getOrDefault(it, 0) + 1 }

    return map.toList().sortedBy { -it.second }.take(k).map { it.first }.toIntArray()
}

fun main() {
    val nums = intArrayOf(1,1,1,2,2,3)

    topKFrequent(nums, 2).forEach { println(it) }
}
