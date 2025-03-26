/*
    Linked List, String, Stack, Design, Simulation, Doubly-Linked List
    2296. Design a Text Editor
    https://leetcode.com/problems/design-a-text-editor/description/
 */

package leetcode.hard

private class TextEditor {
    private data class Node(
        val char: Char,
        var prev: Node? = null,
        var next: Node? = null,
    )
    private val head: Node = Node('_')
    private val tail: Node = Node('_')
    private var lptr = head
    private var cursor = head
    private var deltaCount = 0


    init {
        head.next = tail
        tail.prev = head
    }

    fun addText(text: String) {
        for (c in text) {
            val node = Node(c, cursor, cursor.next)
            cursor.next!!.prev = node
            cursor.next = node
            cursor = cursor.next!!
            if (deltaCount < 10)
                ++deltaCount
            else
                lptr = lptr.next!!
        }
    }

    fun deleteText(k: Int): Int {
        if (cursor == head) return 0

        val end = cursor.next!!
        var count = 0
        while (count < k && cursor != head) {
            if (lptr == head)
                --deltaCount
            else
                lptr = lptr.prev!!

            ++count
            cursor = cursor.prev!!
        }

        cursor.next = end
        end.prev = cursor

        return count
    }

    fun cursorLeft(k: Int): String {
        var count = 0
        while (count < k && cursor != head) {
            if (lptr == head)
                --deltaCount
            else
                lptr = lptr.prev!!

            count++
            cursor = cursor.prev!!
        }

        return getWord(cursor.next!!)
    }

    fun cursorRight(k: Int): String {
        var count = 0
        while (count < k && cursor != tail.prev) {
            if (deltaCount < 10)
                ++deltaCount
            else
                lptr = lptr.next!!

            count++
            cursor = cursor.next!!
        }

        return getWord(cursor.next!!)
    }

    private fun getWord(end: Node): String {
        return buildString {
            var start = lptr.next!!
            while (start != end) {
                append(start.char)
                start = start.next!!
            }
        }
    }
}
