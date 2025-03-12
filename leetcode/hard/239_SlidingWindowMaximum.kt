/*
    Array, Queue, Sliding Window, Heap (Priority Queue), Monotonic Queue
    239. Sliding Window Maximum
    https://leetcode.com/problems/sliding-window-maximum/description/
 */

package leetcode.hard

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.indices
import kotlin.collections.toList


private fun maxSlidingWindow2(nums: IntArray, k: Int): IntArray {
    val res = IntArray(nums.size - k + 1)
    val pq = PriorityQueue<Int>(4)

    var l = 0
    for (i in nums.indices) {
        if (i - l >= k) {
            res[l] = -pq.peek()
            pq.remove(-nums[l++])
        }
        pq.add(-nums[i])
    }
    res[l] = -pq.peek()

    return res
}

private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val res = IntArray(nums.size - k + 1)
    val deque: Deque<Int> = java.util.ArrayDeque(nums.size)

    var j = 0
    for (i in nums.indices) {
        if (deque.isNotEmpty() && i - k + 1 > deque.peekFirst())
            deque.pollFirst()

        while (deque.isNotEmpty() && nums[deque.peekLast()] <= nums[i])
            deque.pollLast()

        deque.offer(i)
        if (i >= k - 1)
            res[j++] = nums[deque.peekFirst()]
    }
    return res
}

fun main() {
    println(maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3).toList())
//    println(maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 4).toList())
    println(maxSlidingWindow(intArrayOf(1,-1), 1).toList())
}
