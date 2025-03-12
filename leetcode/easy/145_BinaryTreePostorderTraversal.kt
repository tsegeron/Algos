package leetcode.easy

import java.util.Stack

/*
    145. Binary Tree Postorder Traversal
    https://leetcode.com/problems/binary-tree-postorder-traversal/description/
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


// Stack
fun postorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    var curNode = root

    while (curNode != null || stack.isNotEmpty()) {
        if (curNode != null) {
            res.add(curNode.`val`)
            stack.push(curNode)
            curNode = curNode.right
        } else {
            curNode = stack.pop()
            curNode = curNode.left
        }
    }

    return res.reversed()
}

/* Recursion
fun postorderTraversal(root: TreeNode?): List<Int> =
    root?.let { postorderTraversal(it.left) + postorderTraversal(it.right) + it.`val` } ?: emptyList()
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

    println(postorderTraversal(root))
}
