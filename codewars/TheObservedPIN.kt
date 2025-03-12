package codewars/*
    Problem Level: 4 kyu

    The observed PIN
    https://www.codewars.com/kata/5263c6999e0f40dee200059d/kotlin

 */

fun main() {
    println(getPINs("8"))
    println(getPINs("11"))
    println(getPINs("369"))
}

private val numNeighbors = mapOf(
    '0' to listOf("0", "8"),
    '1' to listOf("1", "2", "4"),
    '3' to listOf("2", "3", "6"),
    '7' to listOf("4", "7", "8"),
    '9' to listOf("6", "8", "9"),
    '2' to listOf("1", "2", "3", "5"),
    '4' to listOf("1", "4", "5", "7"),
    '6' to listOf("3", "5", "6", "9"),
    '5' to listOf("2", "4", "5", "6", "8"),
    '8' to listOf("5", "7", "8", "9", "0"),
)

private fun generateCombos(allVars: List<List<String>>): List<String> {
    if (allVars.isEmpty()) return listOf("")

    val firstVars = allVars.first()
    val remainingVars = allVars.drop(1)

    val res = mutableListOf<String>()
    for (v in firstVars) {
        val subCombs = generateCombos(remainingVars)
        subCombs.forEach { res.add(v + it) }
    }

    return res
}

private fun getPINs(observed: String): List<String> =
    generateCombos(observed.map { numNeighbors[it]!! })
