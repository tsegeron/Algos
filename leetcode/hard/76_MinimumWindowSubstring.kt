/*
    Hash Table, String, Sliding Window
    76. Minimum Window Substring
    https://leetcode.com/problems/minimum-window-substring/description/
 */

package leetcode.hard

private fun minWindow(s: String, t: String): String {
    if (t.length > s.length)
        return ""

    var minLen = t.length
    val tCount = IntArray(58).apply { t.forEach { ++this[it - 'A'] } }

    var res = ""
    var sl = 0
    for (i in s.indices) {
        if (tCount[s[i] - 'A']-- > 0)
            minLen--

        while (minLen == 0) {
            if (res.isEmpty() || i - sl + 1  < res.length)
                res = s.substring(sl..i)
            if (tCount[s[sl++] - 'A']++ == 0)
                minLen++
        }
    }

    return res
}

fun main() {
    println(minWindow("ADOBECODEBANC", "ABC"))
    println(minWindow("a", "a"))
    println(minWindow("a", "aa"))
    println(minWindow("ab", "b"))
    println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd")) // abbbbbcdd
}


