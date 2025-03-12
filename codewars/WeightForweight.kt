package codewars

fun main() {
    println(orderWeight("56 65 74 100 99 68 86 180 90"))
    println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"))
}

private fun orderWeight(string:String):String = string
    .split(" ")
    .sortedWith(compareBy({ it.sumOf { c -> c - '0' } }, { it }))
    .joinToString(" ")
