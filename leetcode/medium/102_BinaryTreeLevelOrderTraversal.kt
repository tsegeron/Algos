/*
    Tree, Breadth-First Search, Binary Tree
    102. Binary Tree Level Order Traversal
    https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */

package leetcode.medium

private fun foo(node: TreeNode?, level: Int, res: MutableList<MutableList<Int>>) {
    if (node == null)
        return
    if (res.size <= level)
        res.add(mutableListOf())

    res[level].add(node.`val`)

    foo(node.left, level + 1, res)
    foo(node.right, level + 1, res)
}

private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()

    foo(root, 0, res)

    return res
}

/* TODO Implement Iterative version using Queue
private fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val res = mutableListOf(mutableListOf<Int>())
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {

    }

    return res
}
*/
