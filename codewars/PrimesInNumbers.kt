package codewars

fun main() {
    println(factors(86240)) // 86240 should return "(2**5)(5)(7**2)(11)"
    println(factors(11)) // 86240 should return "(2**5)(5)(7**2)(11)"
}

private fun factors(l: Int): String {
    var res = ""
    var num = l

    for (d in 2..l/2) {
        var count = 0

        while (num % d == 0) {
            num /= d
            ++count
        }

        if (count != 0)
            res += if (count == 1) "($d)" else "($d**$count)"
    }
    return res.ifBlank { "($l)" }
}
