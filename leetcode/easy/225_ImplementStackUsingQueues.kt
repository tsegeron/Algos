package leetcode.easy

import java.util.LinkedList

/*
    225. Implement Stack using Queues
    https://leetcode.com/problems/implement-stack-using-queues/description/
 */

private class MyStack() {
    val q1 = LinkedList<Int>()
    val q2 = LinkedList<Int>()

    fun push(x: Int) {
        while (q1.isNotEmpty())
            q2.add(q1.poll())
        q1.add(x)
        while (q2.isNotEmpty())
            q1.add(q2.poll())
    }

    fun pop(): Int = q1.poll()

    fun top(): Int = q1.peek()

    fun empty(): Boolean = q1.isEmpty()
}
