package leetcode.easy

import java.util.*

/*
    496. Next Greater Element I
    https://leetcode.com/problems/next-greater-element-i/description/
 */

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val res = mutableMapOf<Int, Int>()
    val stack = Stack<Int>()

    for (num in nums2) {
        while (stack.isNotEmpty() && stack.peek() < num)
            res[stack.pop()] = num
        stack.push(num)
    }

    return nums1.map { res.getOrDefault(it, -1) }.toIntArray()
}

fun main() {
    println(nextGreaterElement(intArrayOf(4,1,2), intArrayOf(1,3,4,2)).toList())
    println(nextGreaterElement(intArrayOf(24), intArrayOf(1,2,3,4)).toList())
}
