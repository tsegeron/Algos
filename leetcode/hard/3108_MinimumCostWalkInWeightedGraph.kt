/*
    Array, Bit Manipulation, Union Find, Graph
    3108. Minimum Cost Walk in Weighted Graph
    https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/description/
    NOTE: solve other UnionFind problems
 */

package leetcode.hard

private class Solution {
    private class UnionFind(size: Int) {
        private val parent = IntArray(size) { it }
        private val depth = IntArray(size) { 1 }

        fun find(node: Int): Int {
            var res = node

            while (res != parent[res]) {
                parent[res] = parent[parent[res]]
                res = parent[res]
            }

            return res
        }

        fun union(node1: Int, node2: Int) {
            var (p1, p2) = find(node1) to find(node2)
            if (p1 == p2) return

            if (depth[p1] < depth[p2])
                p1 = p2.also { p2 = p1 }

            parent[p2] = p1
            depth[p1] += depth[p2]
        }
    }

    fun minimumCost(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val res = IntArray(query.size) { -1 }
        val uf = UnionFind(n)
        val cost = IntArray(n) { -1 }

        for ((a,b,_) in edges)
            uf.union(a, b)

        for ((a,_,c) in edges) {
            val root = uf.find(a)
            cost[root] = cost[root] and c
        }

        for (i in query.indices) {
            val (start, end) = query[i]
            val (root1, root2) = uf.find(start) to uf.find(end)

            if (root1 != root2) continue
            res[i] = cost[root1]
        }

        return res
    }
}

fun main() {
//    Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]]
    val s = Solution()

    println(
        s.minimumCost(
            5,
            arrayOf(intArrayOf(0,1,7), intArrayOf(1,3,7), intArrayOf(1,2,1)),
            arrayOf(intArrayOf(0,3), intArrayOf(3,4))
        ).toList()
    ) // [1,-1]

//    Input: n = 3, edges = [[0,2,7],[0,1,15],[1,2,6],[1,2,1]], query = [[1,2]]
    println(
        s.minimumCost(
            3,
            arrayOf(intArrayOf(0,2,7), intArrayOf(0,1,15), intArrayOf(1,2,6), intArrayOf(1,2,1)),
            arrayOf(intArrayOf(1,2))
        ).toList()
    ) // [0]

//    Input: n = 3, edges = [[1,0,4],[0,2,5],[0,2,3],[0,2,14],[0,2,12],[2,0,14],[0,2,4]], query = [[2,1]]
    println(
        s.minimumCost(
            3,
            arrayOf(intArrayOf(1,0,4), intArrayOf(0,2,5), intArrayOf(0,2,3), intArrayOf(0,2,14), intArrayOf(0,2,12), intArrayOf(2,0,14), intArrayOf(0,2,4)),
            arrayOf(intArrayOf(1,2))
        ).toList()
    ) // [0]
}
