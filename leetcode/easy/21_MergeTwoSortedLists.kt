package leetcode.easy

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    else if (list2 == null) return list1

    var l1: ListNode? = list1
    var l2: ListNode? = list2
    val head = if (l1!!.`val` < l2!!.`val`) l1 else l2
    var cur: ListNode? = head

    while (l1 != null && l2 != null) {
        cur?.next = if (l1.`val` < l2.`val`) l1.also { l1 = l1?.next } else l2.also { l2 = l2?.next }
        cur = cur?.next
    }

    cur?.next = if (l1 != null) l1 else l2

    return head
}

fun main() {
    val l1 = ListNode(1).apply { next = ListNode(3) }
    val l2 = ListNode(2).apply { next = ListNode(4) }

    var merged = mergeTwoLists(l1, l2)

    while (merged != null)
        println(merged.`val`).also { merged = merged?.next }
}
