package leetcode.medium

/*
    Linked List, Two Pointers
    19. Remove Nth Node From End of List
    https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */

private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var prev: ListNode? = null
    var slow = head
    var count = 1

    while (slow?.next != null)
        slow = slow.next.also { ++count }

    if (count > n)
        prev = head

    while (--count > n)
        prev = prev?.next

    if (prev == null)
        return head?.next

    prev.next = prev.next?.next

    return head
}

fun main() {
    val list1 = ListNode(1)
    val list2 = ListNode(1).apply { next = ListNode(2) }
    val list5 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }

    println(removeNthFromEnd(list1, 1)?.`val`)
    println(removeNthFromEnd(list2, 1)?.`val`)
//    println(removeNthFromEnd(list2, 2)?.`val`)
    println(removeNthFromEnd(list5, 4)?.`val`)

}
