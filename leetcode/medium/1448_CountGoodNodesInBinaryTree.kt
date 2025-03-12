/*
    Tree, Depth-First Search, Breadth-First Search, Binary Tree
    1448. Count Good Nodes in Binary Tree
    https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 */

package leetcode.medium

private fun foo(root: TreeNode?, prevMax: Int): Int {
    if (root == null)
        return 0

    val newMax = if (prevMax > root.`val`) prevMax else root.`val`
    val add = if (root.`val` < prevMax) 0 else 1

    return add + foo(root.left, newMax) + foo(root.right, newMax)
}

private fun goodNodes(root: TreeNode?): Int {
    return foo(root, Int.MIN_VALUE)
}
