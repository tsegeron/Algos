/*
    Array, Stack, Monotonic Stack
    739. Daily Temperatures
    https://leetcode.com/problems/daily-temperatures/description/
 */

package leetcode.medium

import java.util.*

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stackIndices = Stack<Int>()
    val result = IntArray(temperatures.size) { 0 }

    for (i in temperatures.indices) {
        while (stackIndices.isNotEmpty() && temperatures[stackIndices.peek()] < temperatures[i]) {
            val prevDayIndex = stackIndices.pop()
            result[prevDayIndex] = i - prevDayIndex
        }
        stackIndices.push(i)
    }

    return result
}

fun main() {
    println(dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)).toList())
    println(dailyTemperatures(intArrayOf(30,40,50,60)).toList())
    println(dailyTemperatures(intArrayOf(30,60,90)).toList())
}
