/*
    Array, Hash Table, Matrix
    73. Set Matrix Zeroes
    https://leetcode.com/problems/set-matrix-zeroes/description/
 */

package leetcode.medium

private class Solution73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var row0 = false
        var col0 = false

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row0 = true
                    if (j == 0) col0 = true
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }

        for (i in matrix.indices.reversed()) {
            if (i == 0 && !row0) continue
            for (j in matrix[0].indices.reversed()) {
                if (j == 0 && !col0) continue
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0
            }
        }
    }
}

fun main() {
//    val matrix = arrayOf(intArrayOf(0,1,2,0), intArrayOf(3,4,5,2), intArrayOf(1,3,1,5))
//    val matrix = arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,0,7,8), intArrayOf(0,10,11,12), intArrayOf(13,14,15,0))
    val matrix = arrayOf(intArrayOf(-4,-2147483648,6,-7,0), intArrayOf(-8,6,-8,-6,0), intArrayOf(2147483647,2,-9,-6,-10))

    Solution73().setZeroes(matrix)
    matrix.forEach { println(it.toList()) }
}
