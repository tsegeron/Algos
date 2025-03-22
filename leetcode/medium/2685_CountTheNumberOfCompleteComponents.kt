/*
    Depth-First Search, Breadth-First Search, Union Find, Graph
    2685. Count the Number of Complete Components
    https://leetcode.com/problems/count-the-number-of-complete-components/description/
 */

package leetcode.medium

private class Solution {
    private class UnionFind(size: Int) {
        private val parent = IntArray(size) { it }
        private val nodesCount = IntArray(size) { 1 }
        private val edgesCount = IntArray(size) { 0 }

        fun find(node: Int): Int {
            var res = node

            while (res != parent[res]) {
                parent[res] = parent[parent[res]]
                res = parent[res]
            }

            return res
        }

        fun union(a: Int, b: Int) {
            var (p1, p2) = find(a) to find(b)

            edgesCount[p1] += 1
            edgesCount[p2] += 1

            if (p1 == p2) return

            if (nodesCount[p1] < nodesCount[p2])
                p1 = p2.also { p2 = p1 }

            parent[p2] = p1
            nodesCount[p1] += nodesCount[p2]
            edgesCount[p1] += edgesCount[p2]
        }

        fun res() = nodesCount.indices.count { nodesCount[it] * (nodesCount[it] - 1) == edgesCount[it] }
    }

    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int = UnionFind(n)
        .apply { edges.forEach { (n1, n2) -> union(n1, n2) } }.res()
}

fun main() {
    val s = Solution()

    println(s.countCompleteComponents(6, arrayOf(intArrayOf(0,1),intArrayOf(0,2),intArrayOf(1,2),intArrayOf(3,4)))) // 3
    println(s.countCompleteComponents(6, arrayOf(intArrayOf(0,1),intArrayOf(0,2),intArrayOf(1,2),intArrayOf(3,4),intArrayOf(3,5)))) // 1
}
