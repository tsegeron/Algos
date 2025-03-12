/*
    215. Kth Largest Element in an Array
    https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */

package leetcode.medium

import java.util.*

private fun findKthLargest(nums: IntArray, k: Int): Int {
    val q = PriorityQueue<Int>()

    for (num in nums) {
        q.add(num)
        if (q.size > k)
            q.poll()
    }

    return q.peek()
}

fun main() {
    println(findKthLargest(intArrayOf(3,2,1,5,6,4), 2))
    println(findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
}
