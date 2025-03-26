/*
    Array, Math, Sorting, Matrix
    2033. Minimum Operations to Make a Uni-Value Grid
    https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/
 */

package leetcode.medium

import kotlin.math.abs

private class Solution2033 {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val nums = grid.flatMap { it.toList() }.sorted()
        val med = nums[nums.size / 2]
        val rem = med % x
        var res = 0

        for (num in nums) {
            if (num % x != rem)
                return -1
            res += abs(num - med) / x
        }
        return res
    }
}

// Time Limit Exceeded
/* Tried an elegant solution
private class Solution2033 {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val size = grid.size * grid[0].size
        val median = quickSelect(grid, 0, size - 1, size / 2)
        val rem = median % x
        var res = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                val curNum = grid[i][j]
                if (curNum % x != rem)
                    return -1
                res += abs(curNum - median) / x
            }
        }

        return res
    }

    private fun quickSelect(grid: Array<IntArray>, l: Int, r: Int, k: Int): Int {
        val n = grid[0].size
        val num: (Int) -> Int = { index -> grid[index / n][index % n] }
        if (l == r)
            return num(l)

        val pivot = partition(grid, l, r)

        return when {
            pivot == k -> num(pivot)
            pivot < k -> quickSelect(grid, pivot + 1, r, k)
            else -> quickSelect(grid, l, pivot - 1, k)
        }
    }

    private fun Array<IntArray>.swap(l: Int, r: Int) {
        val n = this[0].size
        this[l / n][l % n] = this[r / n][r % n].also { this[r / n][r % n] = this[l / n][l % n] }
    }

    private fun partition(grid: Array<IntArray>, left: Int, right: Int): Int {
        val n = grid[0].size
        val num: (Int) -> Int = { index -> grid[index / n][index % n] }

        grid.swap(right, (left..right).random())
        var l = left

        for (i in left until right) {
            if (num(i) < num(right))
                grid.swap(i, l++)
        }
        grid.swap(l, right)
        return l
    }
}
 */
