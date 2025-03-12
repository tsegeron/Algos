/*
    String, Dynamic Programming, Backtracking
    22. Generate Parentheses
    https://leetcode.com/problems/generate-parentheses/description/
 */

package leetcode.medium

private fun generateParenthesis(n: Int): List<String> {
    val res = mutableListOf<String>()

    fun foo(left: Int, right: Int, cur: String) {
        if (cur.length == n * 2)
            res.add(cur).also { return }
        if (left < n)
            foo(left + 1, right, "$cur(")
        if (right < left)
            foo(left, right + 1, "$cur)")
    }

    foo(0, 0, "")

    return res
}

// ()
// (()) ()()
// ((())) (()()) (())() ()(()) ()()()

fun main() {
//    println(generateParenthesis(1))
    println(generateParenthesis(2))
    println(generateParenthesis(3))
}
