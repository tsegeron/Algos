/*
    234. Palindrome Linked List
    https://leetcode.com/problems/palindrome-linked-list/description/
 */

package leetcode.easy

import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// Intentionally was solved using Stack
private fun isPalindrome(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    val stack = Stack<Int>()

    while (fast?.next != null) {
        stack.push(slow!!.`val`)
        slow = slow.next
        fast = fast.next?.next
    }
    if (fast != null) {
        slow = slow!!.next
    }

    while (stack.isNotEmpty()) {
        if (stack.pop() != slow!!.`val`)
            return false
        slow = slow.next
    }

    return true
}
