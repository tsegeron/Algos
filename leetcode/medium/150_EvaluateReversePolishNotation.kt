/*
    Array, Math, Stack
    150. Evaluate Reverse Polish Notation
    https://leetcode.com/problems/evaluate-reverse-polish-notation/description
 */

package leetcode.medium

import java.util.*

private fun evalRPN(tokens: Array<String>): Int {
    val stackNumbers = Stack<Int>()

    for (token in tokens) {
        stackNumbers.push(
            when (token) {
                "+" -> stackNumbers.pop() + stackNumbers.pop()
                "-" -> -stackNumbers.pop() + stackNumbers.pop()
                "*" -> stackNumbers.pop() * stackNumbers.pop()
                "/" -> stackNumbers.pop().let { stackNumbers.pop() / it }
                else -> token.toIntOrNull()
            }
        )
    }

    return stackNumbers.pop()
}

fun main() {
    val tokens1 = arrayOf("2","1","+","3","*")
    val tokens2 = arrayOf("4","13","5","/","+")
    val tokens3 = arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")

    println(evalRPN(tokens1))
    println(evalRPN(tokens2))
    println(evalRPN(tokens3))
}
