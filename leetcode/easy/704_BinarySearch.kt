/*
    704. Binary Search
    https://leetcode.com/problems/binary-search/description/
 */

package leetcode.easy

private fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = (left + right) / 2

        when {
            nums[mid] == target -> return mid
            nums[mid] > target -> right = mid - 1
            nums[mid] < target -> left = mid + 1
        }
    }

    return -1
}
