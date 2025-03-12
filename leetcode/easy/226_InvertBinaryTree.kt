package leetcode.easy

private fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null)
        return null

    root.left = invertTree(root.right).also {
        root.right = invertTree(root.left)
    }

    return root
}
