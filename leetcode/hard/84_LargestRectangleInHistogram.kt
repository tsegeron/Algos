/*
    84. Largest Rectangle in Histogram
    https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */

package leetcode.hard

fun largestRectangleArea(heights: IntArray): Int {
    var max = 0
//    val stack = Stack<Int>()
//    var prevMaxi = 0
//
//    for (i in heights.indices) {
//        if (heights[i] > heights[prevMaxi])
//            prevMaxi = i
//
//        if (stack.isEmpty())
//            stack.push(heights[i])
//        else {
//            if (stack.peek() == heights[i])
//        }
//    }

    return max
}

fun main() {
//    println(largestRectangleArea(intArrayOf(2,1,5,6,2,3))) // 10
//    println(largestRectangleArea(intArrayOf(2,4))) // 4
//    println(largestRectangleArea(intArrayOf(1,1))) // 2
    println(largestRectangleArea(intArrayOf(2,1,2))) // 3
}
