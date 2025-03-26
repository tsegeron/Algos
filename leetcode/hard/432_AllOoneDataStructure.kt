/*
    Hash Table, Linked List, Design, Doubly-Linked List
    432. All O`one Data Structure
    https://leetcode.com/problems/all-oone-data-structure/description/
 */

package leetcode.hard

// !!! Each function must run in O(1) average time complexity.

/*
    Intuition:
    hashmap<String, Int> to maintain count
    maximal/minimal count
        1. maybe LinkedList
        2. maybe TreeMap with Value to Frequency
        3. maybe deque
        4. maybe double stack

    Final:
    hashmap<String, Node> for O(1) access
    LinkedList for max/min (inc/dec takes O(k), k – nodes between current and next greater/lower freq node)

    After Solving (the fastest solution's approach):
    hashmap<String, Node> for O(1) access
    LinkedList but with one Node for each frequency with hashSet of keys
 */

private class AllOne() {
    private data class Node(
        var freq: Int,
        val key: String,
        var prev: Node? = null,
        var next: Node? = null
    )

    private val key2node = HashMap<String, Node>()
    private val head = Node(Int.MIN_VALUE, "")
    private val tail = Node(Int.MAX_VALUE, "")

    init {
        head.next = tail
        tail.prev = head
    }

    private fun moveNode(node: Node, nextNode: Node) {
        // remove from the previous place
        node.prev!!.next = node.next
        node.next!!.prev = node.prev

        // add to the new place
        node.next = nextNode
        node.prev = nextNode.prev
        nextNode.prev!!.next = node
        nextNode.prev = node
    }

    fun inc(key: String) {
        if (key !in key2node) {
            val node = Node(1, key, head, head.next)
            head.next!!.prev = node
            head.next = node
            key2node[key] = node
            return
        }
        val node = key2node[key]!!.apply { freq += 1 }
        var tmp = node.next!!
        while (tmp.freq < node.freq)
            tmp = tmp.next!!
        if (tmp.prev!!.key != node.key)
            moveNode(node, tmp)
    }

    fun dec(key: String) {
        val node = key2node[key]!!.apply { freq -= 1 }
        if (node.freq == 0) {
            node.prev!!.next = node.next
            node.next!!.prev = node.prev
            node.next = null
            node.prev = null
            key2node.remove(key)
            return
        }

        var tmp = node
        while (tmp.prev!!.freq > node.freq)
            tmp = tmp.prev!!
        if (tmp.key != node.key)
            moveNode(node, tmp)
    }

    fun getMaxKey(): String {
        if (tail.prev == head)
            return ""
        return tail.prev!!.key
    }

    fun getMinKey(): String {
        if (head.next == tail)
            return ""
        return head.next!!.key
    }
}

fun main() {
    val allOne = AllOne()
    allOne.inc("hello")
    allOne.inc("goodbye")
    allOne.inc("leet")
    allOne.inc("code")
    allOne.inc("goodbye")
    println(allOne.getMaxKey())
}

