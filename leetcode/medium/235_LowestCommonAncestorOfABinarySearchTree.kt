/*
    Tree, Depth-First Search, Binary Search Tree, Binary Tree
    235. Lowest Common Ancestor of a Binary Search Tree
    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */

package leetcode.medium

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    val min = minOf(p!!.`val`, q!!.`val`)
    val max = maxOf(p.`val`, q.`val`)

    if (max >= root!!.`val` && min <= root.`val`)
        return root

    var r = root
    while (min > r!!.`val` || max < r.`val`) {
        if (min > r.`val`)
            r = r.right
        if (max < r!!.`val`)
            r = r.left
    }

    return r
}
