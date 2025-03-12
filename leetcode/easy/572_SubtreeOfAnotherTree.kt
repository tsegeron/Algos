package leetcode.easy

private fun foo(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null)
        return true
    if (left == null || right == null || left.`val` != right.`val`)
        return false
    return foo(left.left, right.left) && foo(left.right, right.right)
}

private fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null)
        return false
    if (foo(root, subRoot))
        return true

    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
}
