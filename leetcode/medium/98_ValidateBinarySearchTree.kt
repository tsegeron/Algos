/*
    Tree, Depth-First Search, Binary Search Tree, Binary Tree
    98. Validate Binary Search Tree
    https://leetcode.com/problems/validate-binary-search-tree/description/
 */

package leetcode.medium

private fun foo(node: TreeNode?, prevMax: Long, prevMin: Long): Boolean {
    if (node == null || node.left == null && node.right == null)
        return true
    if (node.right != null && (node.right!!.`val` <= node.`val` || node.right!!.`val` >= prevMax))
        return false
    if (node.left != null && (node.left!!.`val` >= node.`val` || node.left!!.`val` <= prevMin))
        return false

    return foo(node.left, node.`val`.toLong(), prevMin) && foo(node.right, prevMax, node.`val`.toLong())
}

private fun isValidBST(root: TreeNode?): Boolean {
    return foo(root, Int.MAX_VALUE + 1L, Int.MIN_VALUE - 1L)
}

// [-2147483648,null,2147483647] nice test case
