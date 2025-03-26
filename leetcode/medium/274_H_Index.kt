/*
    Array, Sorting, Counting Sort
    274. H-Index
    https://leetcode.com/problems/h-index/description/
 */

package leetcode.medium

private class Solution274 {
    fun hIndex(citations: IntArray): Int {
        val max = citations.size
        val count = IntArray(max + 1)
        for (num in citations)
            ++count[minOf(num, max)]

        var prefixCount = 0
        for (i in count.size - 1 downTo 0) {
            prefixCount += count[i]
            if (i <= prefixCount) return i
        }

        return 0
    }
}
