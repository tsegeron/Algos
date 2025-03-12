/*
    Array, Hash Table, Matrix
    36. Valid Sudoku
    https://leetcode.com/problems/valid-sudoku/description/
 */

package leetcode.medium

// One-liner, 156 chars
private fun isValidSudoku(b: Array<CharArray>): Boolean = (0..8).all { n->
    listOf(
        b[n].toList(),
        (0..8).map { b[it][n] },
        (0..8).map { b[n*3%9 + it/3][n/3*3 + it%3] }
    ).all{ it.filter(Char::isDigit).let{ l-> l.size == l.toSet().size } }
}
