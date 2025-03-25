/*
    Hash Table, Linked List, Design, Doubly-Linked List
    1797. Design Authentication Manager
    https://leetcode.com/problems/design-authentication-manager/description/
 */

package leetcode.medium

/*
    – Was done intentionally using LinkedList for practice
    – Using map is far easier + using MinHeap is more effective
 */
private class AuthenticationManager(private val timeToLive: Int) {
    private data class Node(
        var expireTime: Int,
        val tokenId: String = "",
        var next: Node? = null,
    )

    private val head = Node(0)
    private var curNode: Node? = head

    private fun moveToUnexpired(currentTime: Int, tokenId: String? = null, count: Boolean = false): Node? {
        var prev = curNode
        while (curNode != null && curNode!!.expireTime <= currentTime) {
            prev = curNode
            curNode = curNode!!.next
        }
        curNode = prev
        if (count) return curNode!!

        var tmp = curNode?.next

        while (tmp != null && ((tokenId == null && tmp.expireTime < currentTime + timeToLive) || (tokenId != null && tmp.tokenId != tokenId))) {
            prev = tmp
            tmp = tmp.next
        }

        return prev
    }

    fun generate(tokenId: String, currentTime: Int) {
        val prev = moveToUnexpired(currentTime)

        prev!!.next = Node(currentTime + timeToLive, tokenId, prev.next)
    }

    fun renew(tokenId: String, currentTime: Int) {
        var prev = moveToUnexpired(currentTime, tokenId)
        if (prev?.next == null) return
        var tmp = prev.next
        val toRenew = tmp!!.copy(expireTime = currentTime + timeToLive)

        prev.next = tmp.next
        tmp = tmp.next
        while (tmp != null && tmp.expireTime < toRenew.expireTime) {
            prev = tmp
            tmp = tmp.next
        }
        toRenew.next = prev?.next
        prev?.next = toRenew
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        var tmp: Node? = moveToUnexpired(currentTime, count = true)?.next
        var count = 0

        while (tmp != null)
            tmp = tmp.next.also { ++count }

        return count
    }
}
