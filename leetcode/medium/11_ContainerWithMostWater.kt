/*
    Array, Two Pointers, Greedy
    11. Container With Most Water
    https://leetcode.com/problems/container-with-most-water/description/
 */

package leetcode.medium

private fun maxArea(height: IntArray): Int {
    var l = 0
    var r = height.lastIndex

    var max = minOf(height[l], height[r]) * (r - l)

    while (l < r) {
        if (height[l] > height[r])
            r--
        else
            l++

        max = maxOf(max, minOf(height[l], height[r]) * (r - l))
    }

    return max
}
