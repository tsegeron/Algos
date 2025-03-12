package codewars

fun main() {
    println(digPow(89, 1))
    println(digPow(695, 2))
    println(digPow(92, 1))
    println(digPow(46288, 3))
}

private fun digPow(n: Int, p: Int): Int {
    return n.toString()
        .mapIndexed { index, num ->
            (1..(index + p)).fold(1) { acc, _ -> acc * (num.code - 48)}
        }
        .sum()
        .let { if (it % n == 0) it / n else - 1 }
}

private fun parse(data: String): List<Int> = buildList {
    data.fold(0) { acc, c ->
        when (c) {
            'i' -> acc + 1
            'd' -> acc - 1
            's' -> acc * acc
            'o' -> acc.also { add(acc) }
            else -> acc
        }
    }
}
