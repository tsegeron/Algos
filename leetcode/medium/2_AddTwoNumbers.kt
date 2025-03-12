/*
    Linked List, Math, Recursion
    2. Add Two Numbers
    https://leetcode.com/problems/add-two-numbers/description/
 */

package leetcode.medium

/**
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
*/

private fun addTwoNumbers(list1: ListNode?, list2: ListNode?): ListNode? {
    var rem = false
    var end: ListNode? = null
    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
        val sum = l1.`val` + l2.`val` + if (rem) 1 else 0
        l1.`val` = sum % 10
        rem = sum > 9

        end = l1
        l2 = l2.next
        l1 = l1.next
    }

    var head = l1 ?: l2
    end!!.next = head
    while (head != null) {
        val sum = head.`val` + if (rem) 1 else 0
        head.`val` = sum % 10
        rem = sum > 9

        end = head
        head = head.next
    }

    if (rem)
        end?.next = ListNode(1)

    return list1
}
