/*
    Hash Table, Two Pointers, String, Sliding Window
    567. Permutation in String
    https://leetcode.com/problems/permutation-in-string/description/
 */

package leetcode.medium

private fun checkInclusion(s1: String, s2: String): Boolean {
    val s1Count = IntArray(26).apply { s1.forEach { ++this[it - 'a'] } }
    var l = 0

    for (i in s2.indices) {
        --s1Count[s2[i] - 'a']

        while (s1Count[s2[i] - 'a'] < 0)
            ++s1Count[s2[l++] - 'a']

        if (i - l + 1 == s1.length && s1Count.all { it == 0 })
            return true
    }

    return false
}

fun main() {
    println(checkInclusion("a", "aaaa"))
    println(checkInclusion("ab", "eidbaooo"))
    println(checkInclusion("ab", "eidboaoo"))
}
