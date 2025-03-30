/*
    Hash Table, Two Pointers, String, Greedy
    763. Partition Labels
    https://leetcode.com/problems/partition-labels/
 */

package leetcode.medium

private class Solution763 {
    fun partitionLabels(s: String): List<Int> {
        val count = IntArray(26)
        for (char in s) ++count[char - 'a']

        val res = mutableListOf<Int>()
        val currentChars = mutableSetOf<Char>()
        var l = 0
        for (i in s.indices) {
            if (--count[s[i] - 'a'] == 0) {
                currentChars.remove(s[i])
                if (currentChars.isEmpty()) {
                    res.add(i - l + 1)
                    l = i + 1
                }
            } else {
                currentChars.add(s[i])
            }
        }
        return res
    }

    // elegant approach from solutions
    fun partitionLabels2(s: String): List<Int> {
        val last = IntArray(26) { -1 }
        for (i in s.indices)
            last[s[i] - 'a'] = i

        val res = mutableListOf<Int>()
        var start = 0
        var end = 0
        for (i in s.indices) {
            end = maxOf(end, last[s[i] - 'a'])

            if (end == i) {
                res.add(end - start + 1)
                start = end + 1
            }
        }
        return res
    }
}
