package leetcode.easy

private fun maxDepth(root: TreeNode?): Int {
    if (root == null)
        return 0
    return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
}

private fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null)
        return 0
    return maxOf(maxDepth(root.left) + maxDepth(root.right), diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right))
}
