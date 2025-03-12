/*
    Array, Hash Table, Greedy
    2910. Minimum Number of Groups to Create a Valid Assignment
    https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment/description/
 */

package leetcode.medium

private fun minGroupsForValidAssignment(balls: IntArray): Int {
    val map = mutableMapOf<Int, Int>()

    for (ball in balls)
        map[ball] = map.getOrDefault(ball, 0) + 1

    val minCount = map.values.min()
    var res = Int.MAX_VALUE
    for (size in 1..minCount) {
        var curRes = 0

        for (count in map.values) {
            val integer = count / (size + 1)
            val rem = count % (size + 1)

            if (rem != 0 && size - rem > integer) {
                curRes = 0
                break
            }
            curRes += integer + if (rem > 0) 1 else 0
        }
        if (curRes != 0)
            res = minOf(res, curRes)
    }

    return res
}

fun main() {
    println(minGroupsForValidAssignment(intArrayOf(1,1,3,3,1,1,2,2,3,1,3,2))) // 5
    println(minGroupsForValidAssignment(intArrayOf(1,1,1,3,1,1,1,1,2,3,1,3,2,1,2,3))) // 5
}
