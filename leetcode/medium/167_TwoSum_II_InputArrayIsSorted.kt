/*
    Array, Two Pointers, Binary Search
    167. Two Sum II - Input Array Is Sorted
    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */

package leetcode.medium

private fun twoSum(numbers: IntArray, target: Int): IntArray {
    val diffsIndexes = mutableMapOf<Int, Int>()

    for (i in numbers.indices) {
        if (diffsIndexes.containsKey(numbers[i]))
            return intArrayOf(diffsIndexes.getValue(numbers[i]), i)
        diffsIndexes[target - numbers[i]] = i
    }

    return intArrayOf()
}
