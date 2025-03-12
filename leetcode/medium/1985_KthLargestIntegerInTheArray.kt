/*
    1985. Find the Kth Largest Integer in the Array
    https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/
 */

package leetcode.medium

import java.util.PriorityQueue

private fun kthLargestNumber(nums: Array<String>, k: Int): String {
    val pq = PriorityQueue(compareBy<String> { it.length }.thenBy { it })

    nums.forEach { pq.add(it).also { if (pq.size > k) pq.poll() } }

    return pq.peek()
}
