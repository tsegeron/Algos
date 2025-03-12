/*
    Array, Prefix Sum
    238. Product of Array Except Self
    https://leetcode.com/problems/product-of-array-except-self/description/
 */

package leetcode.medium

private fun productExceptSelf(nums: IntArray): IntArray {
    val res = IntArray(nums.size) { 1 }

    var left = 1
    var right = 1
    for (i in nums.indices) {
        res[i] *= left
        left *= nums[i]

        res[nums.lastIndex - i] *= right
        right *= nums[nums.lastIndex - i]
    }

    return res
}

fun main() {
//    val nums = intArrayOf(-1,1,0,-3,3)
    val nums = intArrayOf(1,2,3,4)
    productExceptSelf(nums).forEach { println(it) }
}

// 1,2,3,4
//

// 1,2,3,4|1,2,3,4|1,2,3,4
// 1,1,2,6
// 24,

// 1,2,3,4
// 24,12,4,1

// 24,12,8,6
