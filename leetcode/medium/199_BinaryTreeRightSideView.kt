/*
    Tree, Depth-First Search, Breadth-First Search, Binary Tree
    199. Binary Tree Right Side View
    https://leetcode.com/problems/binary-tree-right-side-view/description/
 */

package leetcode.medium

private fun foo(node: TreeNode?, level: Int, res: MutableList<Int>) {
    if (node == null)
        return

    if (res.size <= level)
        res.add(node.`val`)
    else
        res[level] = node.`val`

    foo(node.left, level + 1, res)
    foo(node.right, level + 1, res)
}

private fun rightSideView(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()

    foo(root, 0, res)

    return res
}
