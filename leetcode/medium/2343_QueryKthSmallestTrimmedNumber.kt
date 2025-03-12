/*
    2343. Query Kth Smallest Trimmed Number
    https://leetcode.com/problems/query-kth-smallest-trimmed-number/description/
 */

package leetcode.medium

import java.util.*

/*
    save [num] with [index] in pair --> (Answer should be an array of indices)
    1 <= nums[i].length <= 100
 */
private fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {
    val pq = PriorityQueue(compareByDescending<Pair<String, Int>> { it.first }.thenByDescending { it.second })
    val maxLen = nums[0].length
    val res = IntArray(queries.size)

    queries.forEachIndexed{ i, (k, l) ->
        nums.forEachIndexed { j, num ->
            pq.add(Pair(num.substring(maxLen - l), j))
            if (pq.size > k) pq.poll()
        }
        res[i] = pq.poll().second
        pq.clear()
    }

    return res
}
