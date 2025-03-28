/*
    Array, Two Pointers, Breadth-First Search, Union Find, Sorting, Heap (Priority Queue), Matrix
    2503. Maximum Number of Points From Grid Queries
    https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/
 */

package leetcode.hard

/*
    queries can be sorted
    grid can be processed beforehand
 */

private class Solution2503 {
    private class UnionFind(size: Int) {
        private val parent = IntArray(size) { it }
        private val size = IntArray(size) { 1 }

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
            if (p1 == p2) return

            if (size[p1] < size[p2])
                p1 = p2.also { p2 = p1 }

            parent[p2] = p1
            size[p1] += size[p2]

        }

        fun getSize(node: Int) = size[find(node)]
    }

    private data class GridCell(val row: Int, val col: Int, val value: Int)
    private val DIRS = listOf<Pair<Int, Int>>(0 to -1, 0 to 1, -1 to 0, 1 to 0)

    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        val (m, n) = grid.size to grid[0].size
        val totalSize = m * n
        val unionFind = UnionFind(totalSize)
        val sortedQuery2Index = queries.zip(queries.indices).sortedBy { it.first }
        val sortedGrid2Index = grid.flatMapIndexed { i, ints ->
            ints.mapIndexed { j, value -> GridCell(j, i, value) }
        }.sortedBy { it.value }

        val answer = IntArray(queries.size)
        var gridIndex = 0 // i < totalSize
        for ((query, queryidx) in sortedQuery2Index) {
            while (gridIndex < totalSize && sortedGrid2Index[gridIndex].value < query) {
                val row = sortedGrid2Index[gridIndex].row
                val col = sortedGrid2Index[gridIndex].col
                val ufidx = col * n + row

                for (dir in DIRS) {
                    val newRow = row + dir.first
                    val newCol = col + dir.second
                    if (newRow >= 0 && newCol >= 0 &&
                        newRow < n && newCol < m &&
                        grid[newCol][newRow] < query)
                        unionFind.union(ufidx, newCol * n + newRow)
                }

                ++gridIndex
            }
            if (query > grid[0][0])
                answer[queryidx] = unionFind.getSize(0)
        }

        return answer
    }
}

fun main() {
//    val grid = arrayOf(intArrayOf(1,2,3),intArrayOf(2,5,7),intArrayOf(3,5,1))
//    val queries = intArrayOf(5,6,2)
//    println(Solution2503().maxPoints(grid, queries).toList())
    println(Solution2503().maxPoints(arrayOf(intArrayOf(5,2,1), intArrayOf(1,1,2)), intArrayOf(3)).toList())
}
