/*
    Hash Table, String, Sliding Window
    424. Longest Repeating Character Replacement
    https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */

package leetcode.medium

private fun characterReplacement(s: String, k: Int): Int {
    val count = mutableMapOf<Char, Int>()
    var l = 0
    var max = 0

    for (i in s.indices) {
        count[s[i]] = count.getOrDefault(s[i], 0) + 1

        val maxCount = count.values.max()
        if (count.values.sum() - maxCount > k)
            count[s[l]] = count[s[l++]]!! - 1

        if (i - l + 1 > max)
            max = i - l + 1
    }

    return max
}

private fun characterReplacement2(s: String, k: Int): Int {
    val count = IntArray(26)
    var l = 0
    var max = 0
    var maxCount = 0

    for (i in s.indices) {
        maxCount = maxOf(maxCount, ++count[s[i] - 'A'])

        while (i - l + 1 - maxCount > k)
            --count[s[l++] - 'A']

        max = maxOf(max, i - l + 1)
    }

    return max
}

fun main() {
    println(characterReplacement("ABAB", 2)) // 4
    println(characterReplacement("AABABBA", 1)) // 4
    println(characterReplacement("BAAA", 0)) // 3
    println(characterReplacement("ABBB", 2)) // 4
    println(characterReplacement("ACBB", 2)) // 4
    println(characterReplacement("ABCD", 2)) // 3
}
