/*
    Array, Binary Search, Matrix
    74. Search a 2D Matrix
    https://leetcode.com/problems/search-a-2d-matrix/description/
 */

package leetcode.medium

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size

    var l = 0
    var r = m * n - 1

    while (l <= r) {
        val mid = l + (r - l) / 2
        val cur = matrix[mid / n][mid % n]

        when {
            cur == target -> return true
            cur > target -> r = mid - 1
            else -> l = mid + 1
        }
    }

    return false
}
