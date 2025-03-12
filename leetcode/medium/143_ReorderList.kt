/*
    Linked List, Two Pointers, Stack, Recursion
    143. Reorder List
    https://leetcode.com/problems/reorder-list/description/
 */

package leetcode.medium

import java.util.Stack

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun reorderList(head: ListNode?): Unit {
    val stack = Stack<ListNode>()

    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    while (slow != null)
        stack.push(slow).also { slow = slow?.next }

    var h = head
    var tmp: ListNode?
    while (stack.isNotEmpty()) {
        tmp = stack.pop()
        tmp.next = h?.next
        h?.next = tmp
        h = tmp.next
    }
}
