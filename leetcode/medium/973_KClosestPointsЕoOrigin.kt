/*
    973. K Closest Points to Origin
    https://leetcode.com/problems/k-closest-points-to-origin/description
 */

package leetcode.medium

import java.util.*

private fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    fun getDistance(point1: IntArray): Int {
        return point1[0] * point1[0] + point1[1] * point1[1]
    }

    val q = PriorityQueue<IntArray> { o1, o2 -> getDistance(o2) - getDistance(o1) }

    for (point in points) {
        q.add(point)
        if (q.size > k)
            q.poll()
    }

    return q.toTypedArray()
}
