/*
    Stack, Design
    155. Min Stack
    https://leetcode.com/problems/min-stack/description/
 */

package leetcode.medium

import java.util.*

private class MinStack() {
    private val minStack = Stack<Int>()
    private val stack = Stack<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (minStack.isEmpty() || minStack.peek() >= `val`) {
            minStack.push(`val`)
        }
    }

    fun pop() {
        if (stack.peek() == minStack.peek())
            minStack.pop()
        stack.pop()
    }

    fun top(): Int = stack.peek()

    fun getMin(): Int = minStack.peek()
}

