/*
    Hash Table, Linked List, Design, Doubly-Linked List
    146. LRU Cache
    https://leetcode.com/problems/lru-cache/description/

    NOTE: REMAKE (The Solution is slow and consuming)
 */

package leetcode.medium

private class LRUCache(private val capacity: Int) {
    private data class Node(
        val key: Int,
        var value: Int,
        var next: Node? = null
    )

    private var head: Node? = null
    private var size = 0

    fun get(key: Int): Int {
        if (bringToFront(key))
            return head!!.value

        return -1
    }

    fun put(key: Int, value: Int) {
        if (bringToFront(key)) {
            head!!.value = value
        } else {
            head = Node(key, value, head)
            size++

            if (size > capacity)
                removeLRU()
        }
    }

    private fun bringToFront(key: Int): Boolean {
        var needle = head
        var prev: Node? = null

        while (needle != null && needle.key != key)
            needle = needle.next.also { prev = needle }

        if (needle == null)
            return false
        if (size == 1)
            return true
        if (prev == null)
            return true

        prev!!.next = needle.next
        needle.next = head
        head = needle

        return true
    }

    private fun removeLRU() {
        var tmp = head
        var prev: Node? = null

        while (tmp?.next != null)
            tmp = tmp.next.also { prev = tmp }

        prev?.next = null

        size--
    }
}
