/*
    Array, Bit Manipulation, Queue, Sliding Window, Prefix Sum
    3191. Minimum Operations to Make Binary Array Elements Equal to One I
    https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
 */

package leetcode.medium

private fun minOperations(nums: IntArray): Int {
    var count = 0

    for (i in 0..nums.size - 3) {
        if (nums[i] == 0) {
            ++count
            nums[i] = nums[i] xor 1
            nums[i + 1] = nums[i + 1] xor 1
            nums[i + 2] = nums[i + 2] xor 1
        }
    }
    if (nums[nums.size - 1] == nums[nums.size - 2] && nums[nums.size - 1] == 1)
        return count

    return -1
}
