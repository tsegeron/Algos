/*
    Hash Table, String, Sliding Window
    1358. Number of Substrings Containing All Three Characters
    https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 */

package leetcode.medium

private fun numberOfSubstrings(s: String): Int {
    var res = 0
    var l = 0
    val occurs = IntArray(3)
    for (i in s.indices) {
        ++occurs[s[i] - 'a']
        while (occurs.all { it > 0 }) {
            --occurs[s[l++] - 'a']
            res += s.length - i
        }
    }
    return res
}
