package codewars

fun main() {
    println(23 == solution(10))
    println(78 == solution(20))
    println(9168 == solution(200))
}

private fun solution(number: Int): Int {
    return ((0 until number step 3).toSet() + (0 until number step 5).toSet()).sum()
}
