package codewars

fun main() {

}

private fun spinWords(sentence: String): String {
    val maxLen = 5

    return sentence
        .split(" ").joinToString(" ") { word ->
            when {
                word.length < maxLen -> word
                else -> word.reversed()
            }
        }
}
