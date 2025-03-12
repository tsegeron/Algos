/*
    Array, Two Pointers, Binary Search, Bit Manipulation
    287. Find the Duplicate Number
    https://leetcode.com/problems/find-the-duplicate-number/description/
 */

package leetcode.medium

private fun findDuplicate(nums: IntArray): Int {
    var slow = nums[0]
    var fast = nums[0]

    do {
        slow = nums[slow]
        fast = nums[nums[fast]]
    } while (slow != fast)

    slow = nums[0]
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[fast]
    }
    return slow
}
