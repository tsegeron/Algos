package codewars

fun main() {
    println(duplicateCount("abcde"))
    println(duplicateCount("abcdea"))
    println(duplicateCount("indivisibility"))

    val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
    println(duplicateCount(text))

}

private fun duplicateCount(text: String): Int {
    val visited = mutableMapOf<Char, Int>()

    for (c in text.lowercase()) {
        visited[c] = visited.getOrDefault(c, 0) + 1
    }

    return visited.count { it.value > 1 }
}

