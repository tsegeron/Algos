package leetcode.easy

import java.util.*

/*
    94. Binary Tree Inorder Traversal
    https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// Stack
private fun inorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    var curNode = root

    while (curNode != null || stack.isNotEmpty()) {
        while (curNode != null) {
            stack.push(curNode)
            curNode = curNode.left
        }
        curNode = stack.pop()
        res.add(curNode.`val`)
        curNode = curNode.right
    }

    return res
}


// Recursion
/*
private fun inorderTraversal(root: TreeNode?): List<Int> =
    root?.let { inorderTraversal(root.left) + root.`val` + inorderTraversal(root.right) } ?: emptyList()
*/

fun main() {
    val root: TreeNode = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5).apply {
                left = TreeNode(6)
                right = TreeNode(7)
            }
        }
        right = TreeNode(3).apply {
            right = TreeNode(8).apply {
                left = TreeNode(9)
            }
        }
    }

    println(inorderTraversal(root))
}
