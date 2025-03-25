/*
    Array, Linked List, Stack, Design, Doubly-Linked List, Data Stream
    1472. Design Browser History
    https://leetcode.com/problems/design-browser-history/description/
 */

package leetcode.medium

private class BrowserHistory(homepage: String) {
    private data class Node(
        val url: String,
        var prev: Node? = null,
        var next: Node? = null,
    )

    private val head = Node(homepage)
    private var current = head

    fun visit(url: String) {
        val newPage = Node(url).apply { prev = current }
        current.next = newPage
        current = current.next!!
    }

    fun back(steps: Int): String {
        var step = steps
        while (step-- != 0 && current.prev != null)
            current = current.prev!!

        return current.url
    }

    fun forward(steps: Int): String {
        var step = steps
        while (step-- != 0 && current.next != null)
            current = current.next!!

        return current.url
    }
}
