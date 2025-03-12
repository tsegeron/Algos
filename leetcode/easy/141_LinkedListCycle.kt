package leetcode.easy

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while(fast != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (fast != null && slow == fast)
            return true
    }

    return false
}
