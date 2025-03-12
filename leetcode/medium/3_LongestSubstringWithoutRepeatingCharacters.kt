/*
    Hash Table, String, Sliding Window
    3. Longest Substring Without Repeating Characters
    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

package leetcode.medium

private fun lengthOfLongestSubstring(s: String): Int {
    val visited = IntArray(128) { -1 }
    var l = 0
    var max = 0

    for (i in s.indices) {
        if (l < visited[s[i].code])
            l = (visited[s[i].code] + 1)
        visited[s[i].code] = i
        if (i - l + 1 > max) max = i - l + 1
    }

    return max
}

fun main() {
//    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("abba"))
}
