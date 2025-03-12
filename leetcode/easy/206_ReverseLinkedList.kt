package leetcode.easy

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var cur = head
    var next: ListNode?

    while (cur != null) {
        next = cur.next
        cur.next = prev
        prev = cur
        cur = next
    }
    return prev
}
