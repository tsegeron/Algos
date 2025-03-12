/*
    Array, Stack, Sorting, Monotonic Stack
    853. Car Fleet
    https://leetcode.com/problems/car-fleet/description/
 */

package leetcode.medium

import java.util.*

private fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val times = position.zip(speed).sortedBy { -it.first }.map { (target - it.first).toFloat() / it.second }
    val res = Stack<Float>()

    times.forEach {
        if (res.isEmpty() || res.peek() < it)
            res.push(it)
    }

    return res.size
}

//  0  3  5  8  10
//  1  3  1  4   2
// 12  3  7  1   1

fun main() {
//    val target = 12
//    val position = intArrayOf(10,8,0,5,3)
//    val speed = intArrayOf(2,4,1,1,3)
//    val target = 10
//    val position = intArrayOf(3)
//    val speed = intArrayOf(3)
    val target = 100
    val position = intArrayOf(0,2,4)
    val speed = intArrayOf(4,2,1)


    println(carFleet(target, position, speed))
}
