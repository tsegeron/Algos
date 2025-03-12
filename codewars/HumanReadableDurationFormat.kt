package codewars

fun main() {
    println(formatDuration(1))
}

private fun formatDuration(seconds: Int): String {
    if (seconds == 0) return "now"

    val res = mutableListOf<String>()
    var s = seconds

    if (s/31_536_000 > 0)
        (s/31_536_000).let { res += "$it year" + if (it>1) "s" else "" }.also { s %= 31_536_000 }
    if (s/86_400 > 0)
        (s/86_400).let { res += "$it day" + if (it>1) "s" else "" }.also { s %= 86_400 }
    if (s/3_600 > 0)
        (s/3_600).let { res += "$it hour" + if (it>1) "s" else "" }.also { s %= 3_600 }
    if (s/60 > 0)
        (s/60).let { res += "$it minute" + if (it>1) "s" else "" }.also { s %= 60 }
    if (s > 0)
        res += "$s second" + if (s>1) "s" else ""

    return if (res.size == 1) res[0] else res.dropLast(1).joinToString(", ") + " and " + res.last()
}

private fun formatDuration1(seconds: Int): String {
    if (seconds == 0) return "now"

    val res = mutableListOf<String>()
    var s = seconds

    if (s/31_536_000 > 0)
        (s/31_536_000).let { res += "$it year" + if (it%10 != 1) "s" else ""}.also { s %= 31_536_000 }
    if (s/86_400 > 0)
        (s/86_400).let { res += "$it day" + if (it%10 != 1) "s" else ""}.also { s %= 86_400 }
    if (s/3_600 > 0)
        (s/3_600).let { res += "$it hour" + if (it%10 != 1) "s" else ""}.also { s %= 3_600 }
    if (s/60 > 0)
        (s/60).let { res += "$it minute" + if (it%10 != 1) "s" else ""}.also { s %= 60 }
    if (s > 0)
        res += "$s second" + if (s%10 != 1) "s" else ""


    return if (res.size == 1) res[0] else res.dropLast(1).joinToString(", ") + " and " + res.last()
}
