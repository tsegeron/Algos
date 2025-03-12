/*
    Tree, Depth-First Search, Binary Search Tree, Binary Tree
    230. Kth Smallest Element in a BST
    https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */

package leetcode.medium

private fun kthSmallest(root: TreeNode?, k: Int): Int {
    var count = 0

    fun foo(node: TreeNode?, k: Int): Int {
        if (node == null)
            return -1

        val left = foo(node.left, k)
        if (left >= 0)
            return left

        if (++count == k)
            return node.`val`

        val right = foo(node.right, k)
        if (right >= 0)
            return right

        return -1
    }

    return foo(root, k)
}

fun main() {
    val tree = TreeNode(5).apply {
        left = TreeNode(3).apply {
            right = TreeNode(4)
            left = TreeNode(2).apply {
                left = TreeNode(1)
            }
        }
        right = TreeNode(6)
    }

    println(kthSmallest(tree, 1))
    println(kthSmallest(tree, 2))
//    println(kthSmallest(tree, 3))
//    println(kthSmallest(tree, 4))
//    println(kthSmallest(tree, 5))
}
