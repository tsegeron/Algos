/*
    Math
    2579. Count Total Number of Colored Cells
    https://leetcode.com/problems/count-total-number-of-colored-cells/description/
 */

package leetcode.medium

// 1 5 13 25 45
//  4 8  12 16
private fun coloredCells(n: Int): Long = 1L + 2L * n * (n - 1L)
