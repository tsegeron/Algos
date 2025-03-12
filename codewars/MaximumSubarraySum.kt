package codewars

fun main() {
/* 6 */    println(maxSequence(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
/* 592 */    println(maxSequence(listOf(20, 13, 52, 86, 13, 65, 58, -24, -47, 44, 19, -28, 15, -22, 67, 58, 33, -32, 7, 54, -41, 4, 90, 7, -33, 84, 30, -1)))
/* 1469 */    println(maxSequence(listOf(47, 8, -42, 85, 8, 94, 68, 12, 80, 47, -2, 65, 82, 80, 10, 20, 47, 21, -44, 71, 26, -12, 14, 18, 33, 9, 87, 22, 96, 17, -3, 12, 34, 8, 64, -21, 5, 20, 75, 24, 69, 80, -43, -32, 86, 24, -19, -4)))
/* 6 */    println(maxSequence(listOf(-49, 31, -47)))
}

private fun maxSequence(arr: List<Int>): Int {
    var sum = 0
    var maxSum = 0

    arr.forEach {
        sum = maxOf(sum + it, it)
        maxSum = maxOf(maxSum, sum)
    }

    return maxSum
}
