/*
    Hash Table, Linked List
    138. Copy List with Random Pointer
    https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */

package leetcode.medium

private class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

private fun copyRandomListOptimized(node: Node?): Node? {
    if (node == null) return null

    val copyMap = mutableMapOf<Node?, Node?>(null to null)
    var head = node

    while (head != null) {
        copyMap[head] = Node(head.`val`)
        head = head.next
    }

    head = node
    while (head != null) {
        copyMap[head]!!.next = copyMap[head.next]
        copyMap[head]!!.random = copyMap[head.random]
        head = head.next
    }

    return copyMap[node]
}


private fun copyRandomList(node: Node?): Node? {
    if (node == null) return null

    val copyList = mutableListOf<Node?>()
    val randMap = mutableMapOf<Int, Int>()

    // ----------------------------------
    // makes copies without `next` and `random` filled
    // saved relations node-random to map(hash, index)
    var count = 0
    var head = node
    while (head != null) {
        randMap[head.hashCode()] = count++
        copyList.add(Node(head.`val`))

        head = head.next
    }
    copyList.add(null)
    // ----------------------------------

    // ----------------------------------
    // filled `next`
    // filled random with index relation from map
    head = node
    count = 0
    while (head != null) {
        copyList[count]!!.next = copyList[count + 1]
        copyList[count]!!.random = copyList[randMap.getOrDefault(head.random.hashCode(), copyList.size - 1)]

        ++count
        head = head.next
    }
    // ----------------------------------

    return copyList.first()
}
