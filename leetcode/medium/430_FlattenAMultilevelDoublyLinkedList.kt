/*
    Linked List, Depth-First Search, Doubly-Linked List
    430. Flatten a Multilevel Doubly Linked List
    https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
 */

package leetcode.medium

import java.util.Stack


private class Solution430 {
    data class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null
    }

    private val head = Node(0)

    fun flatten(root: Node?): Node? {
        head.next = root
        val stack = Stack<Node?>()
        var curNode = root

        while (curNode != null || stack.isNotEmpty()) {
            if (curNode?.next == null && stack.isNotEmpty()) {
                val tmp = stack.pop()
                tmp?.prev = curNode
                curNode?.next = tmp
            }

            if (curNode?.child != null) {
                stack.push(curNode.next)
                curNode.child?.prev = curNode
                curNode.next = curNode.child
                curNode.child = null
            }
            curNode = curNode?.next
        }

        return head.next
    }
}

private typealias Node1 = Solution430.Node

fun main() {
    val root = Node1(1).apply {
        next = Node1(2).apply {
            next = Node1(3).apply {
                child = Node1(7).apply {
                    next = Node1(8).apply {
                        next = Node1(9)
                    }
                }
                next = Node1(4).apply {
                    next = Node1(5).apply {
                        next = Node1(6)
                    }
                }
            }
        }
    }

    Solution430().flatten(root)

    var tmp: Node1? = root
    while (tmp != null) {
        println(tmp.`val`)
        tmp = tmp.next
    }
}


