package codewars

fun main() {
//    val n = 2
//    val m = 14 // 105
//    foo(2, 14) // 105
//    foo(4, 17) // 3213
    foo(7, 20) // 137979
//    foo(16, 19) // 524096
}

private fun foo(n: Int, m: Int) {
    var step = 1
    var stepAdd = n - 1
    var height = 0

    for (i in 1 until n) {
        var left = m
        while (left-- > 0) {
            height += step
            step += stepAdd
        }
        stepAdd -= 1
    }
    println(height)
}
