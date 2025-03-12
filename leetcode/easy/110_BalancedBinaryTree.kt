package leetcode.easy

private fun dfs(root: TreeNode?): Int {
    if (root == null)
        return 0

    val left = dfs(root.left)
    if (left == -1)
        return -1

    val right = dfs(root.right)
    if (right == -1)
        return -1

    if (left - right !in -1..1)
        return -1

    return 1 + maxOf(left, right)
}

fun isBalanced(root: TreeNode?): Boolean {
    return dfs(root) != -1
}
