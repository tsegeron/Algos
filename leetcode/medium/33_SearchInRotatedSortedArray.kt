/*
    Array, Binary Search
    33. Search in Rotated Sorted Array
    https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */

package leetcode.medium

private fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1

    while(l <= r) {
        val mid = l + (r - l) / 2

        if (nums[mid] == target)
            return mid

        if (nums[mid] >= nums[l]) {
            if (nums[l] <= target && target < nums[mid])
                r = mid - 1
            else
                l = mid + 1
        } else {
            if (nums[mid] < target && target <= nums[r])
                l = mid + 1
            else
                r = mid - 1
        }
    }

    return -1
}

fun main() {

    println(search(intArrayOf(4,5,6,7,0,1,2), 4))
    println(search(intArrayOf(4,5,6,7,0,1,2), 3))
    println(search(intArrayOf(1,3), 3))
    println(search(intArrayOf(5,1,3), 3))
}
