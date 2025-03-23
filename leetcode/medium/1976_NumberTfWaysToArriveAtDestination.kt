/*
    Dynamic Programming, Graph, Topological Sort, Shortest Path
    1976. Number of Ways to Arrive at Destination
    https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

 */

package leetcode.medium

import java.util.PriorityQueue

//    Dijkstra's Algorithm
private class Solution_1976 {
    private val mod = 1_000_000_007

    // find paths from 0 to n-1
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val paths = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for ((a, b, d) in roads) {
            paths[a].add(b to d)
            paths[b].add(a to d)
        }

        val pathCount = IntArray(n).apply { this[0] = 1 }
        val fastestTime = LongArray(n) { Long.MAX_VALUE }
        val queue = PriorityQueue<Pair<Int, Long>>(compareBy { it.second }).apply { add(0 to 0) }

        while (queue.isNotEmpty()) {
            val (curNode, curTime) = queue.poll()
            if (curTime > fastestTime[curNode]) continue

            for ((nextNode, nextTime) in paths[curNode]) {
                val totalTime = curTime + nextTime

                if (totalTime < fastestTime[nextNode]) {
                    fastestTime[nextNode] = totalTime
                    pathCount[nextNode] = pathCount[curNode]
                    queue.add(nextNode to totalTime)
                } else if (totalTime == fastestTime[nextNode]) {
                    pathCount[nextNode] = (pathCount[curNode] + pathCount[nextNode]) % mod
                }
            }
        }
        return pathCount.last()
    }
}

fun main() {
    val s = Solution_1976()

    val paths1 = arrayOf(intArrayOf(0,6,7),intArrayOf(0,1,2),intArrayOf(1,2,3),intArrayOf(1,3,3),intArrayOf(6,3,3),intArrayOf(3,5,1),intArrayOf(6,5,1),intArrayOf(2,5,1),intArrayOf(0,4,5),intArrayOf(4,6,2))
    println(s.countPaths(7, paths1))
    println(s.countPaths(2, arrayOf(intArrayOf(1,0,10))))

}
