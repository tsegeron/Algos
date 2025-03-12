/*
    Array, Hash Table, Union Find
    128. Longest Consecutive Sequence
    https://leetcode.com/problems/longest-consecutive-sequence/description/
 */

package leetcode.medium

private fun longestConsecutive(nums: IntArray): Int {
    val numsSet = nums.toSet()
    var max = 0

    for (num in numsSet) {
        if (num - 1 in numsSet) continue
        var curLen = 1
        var curnum = num

        while (curnum + 1 in numsSet) {
            curLen += 1
            curnum += 1
        }
        max = maxOf(max, curLen)
    }

    return max
}


// Exceeds Memory Limit #67
/*
fun longestConsecutive(nums: IntArray): Int {
    val res = mutableMapOf<Int, Set<Int>>()

    for (num in nums) {
        res[num] = res.getOrDefault(num, emptySet()) + num
        if (num + 1 in res.keys) {
            res[res[num + 1]!!.last()] = res[num]!! + res[res[num + 1]!!.first()]!!
            res[res[num]!!.first()] = res[res[num]!!.first()]!! + res[res[num + 1]!!.last()]!!
        }
        if (num - 1 in res.keys) {
            res[res[num - 1]!!.first()] = res[res[num - 1]!!.first()]!! + res[num]!!
            res[res[num]!!.last()] = res[res[num - 1]!!.first()]!! + res[res[num]!!.last()]!!
        }
    }
    return res.maxOfOrNull { it.value.size } ?: 0
}
*/
