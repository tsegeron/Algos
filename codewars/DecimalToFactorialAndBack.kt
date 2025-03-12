package codewars

fun main() {
//    println(dec2FactString(463))
//    println(factString2Dec("341010"))
//    println(dec2FactString(36288000L))
//    println(factString2Dec("A0000000000"))
//    println(dec2FactString(3595156160L))
//    println(factString2Dec("7607244231100"))
    println(codewars.dec2FactString(7890123456L))
    println(codewars.factString2Dec("13573044440000"))
}

private fun dec2FactString(n: Long): String {
    var num = n
    var res = ""

    var d = 1
    while (num > 0) {
        val rem: Char = (num % d).toInt().let { if (it < 10) '0' + it else 'A' + (it - 10) }
        res = "$rem$res"
        num /= d++
    }

    return res
}

private fun factString2Dec(str: String): Long {
    var res: Long = 0
    var mult: Long = 1

    str.reversed().forEachIndexed { index, c ->
        val num: Int = when (c) {
            in '0'..'9' -> c - '0'
            else -> c - 'A' + 10
        }
        res += num * mult
        mult *= index + 1
    }

    return res
}
