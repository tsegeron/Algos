/*
    Stack, Design, Monotonic Stack, Data Stream
    901. Online Stock Span
    https://leetcode.com/problems/online-stock-span/description/
 */

package leetcode.medium

import java.util.*

private class StockSpanner() {

    private val stack = Stack<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var count = 1

        while (stack.isNotEmpty() && stack.peek().first <= price)
            count += stack.pop().second

        stack.push(price to count)

        return count
    }
}
