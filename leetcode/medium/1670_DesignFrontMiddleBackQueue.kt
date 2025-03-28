/*
    Array, Linked List, Design, Queue
    1670. Design Front Middle Back Queue
    https://leetcode.com/problems/design-front-middle-back-queue/description/
 */

package leetcode.medium

/*
    Double-Linked list
    3 pointers: head, tail, mid
 */
private class FrontMiddleBackQueue() {
    private data class Node(
        val value: Int,
        var next: Node? = null,
        var prev: Node? = null,
    )

    private val head = Node(0)
    private val tail = Node(0)
    private var mid: Node
    private var size = 0

    init {
        head.next = tail
        tail.prev = head
        mid = head
    }

    private fun push(value: Int, beforeNode: Node) {
        val node = Node(value, beforeNode.next, beforeNode)
        beforeNode.next!!.prev = node
        beforeNode.next = node
        ++size

        if (size == 1)
            mid = head.next!!
    }

    private fun pop(node: Node): Int {
        if (size == 0) return -1

        node.prev!!.next = node.next
        node.next!!.prev = node.prev
        --size

        return node.value
    }

    fun pushFront(value: Int) {
        push(value, head)

        if (size % 2 == 0)
            mid = mid.prev!!
    }

    fun pushMiddle(value: Int) {
        if (size < 2) {
            pushFront(value)
        } else if (size % 2 == 0) {
            push(value, mid)
            mid = mid.next!!
        } else {
            push(value, mid.prev ?: head)
            mid = mid.prev!!
        }
    }

    fun pushBack(value: Int) {
        push(value, tail.prev!!)
        if (size != 1 && size % 2 == 1)
            mid = mid.next!!
    }

    fun popFront(): Int = pop(head.next!!).also {
        if (size == 0) mid = head
        else if (size % 2 == 1) mid = mid.next!!
    }

    fun popMiddle(): Int = pop(mid).also {
        mid = if (size == 0) head
        else if (size % 2 == 1) mid.next!! else mid.prev!!
    }

    fun popBack(): Int = pop(tail.prev!!).also {
        if (size == 0) mid = head
        else if (size % 2 == 0) mid = mid.prev!!
    }
}

fun main() {
    val q = FrontMiddleBackQueue()

    q.pushMiddle(1)
    q.pushMiddle(2)
    q.pushMiddle(3)
    println(q.popMiddle())
    println(q.popMiddle())
    println(q.popMiddle())
    println(q.popMiddle())
}
