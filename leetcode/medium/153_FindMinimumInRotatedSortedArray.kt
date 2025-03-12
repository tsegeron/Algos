/*
    Array, Binary Search
    153. Find Minimum in Rotated Sorted Array
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */

package leetcode.medium

private fun findMin(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1

    while (l < r) {
        val mid = l + (r - l) / 2

        if (nums[mid] > nums[r])
            l = mid + 1
        else
            r = mid

    }

    return nums[l]
}

fun main() {
    println(findMin(intArrayOf(4,5,6,7,0,1,2)))
}
