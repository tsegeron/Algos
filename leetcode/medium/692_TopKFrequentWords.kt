/*
    Array, Hash Table, String, Trie, Sorting, Heap (Priority Queue), Bucket Sort, Counting
    692. Top K Frequent Words
    https://leetcode.com/problems/top-k-frequent-words/description/

    NOTE: come back and try with BucketSort, Trie
 */

package leetcode.medium

import java.util.*

private fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val pq = PriorityQueue(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first })
    val frequency = mutableMapOf<String, Int>()

    for (word in words)
        frequency[word] = frequency.getOrDefault(word, 0) + 1

    for (pair in frequency)
        pq.add(pair.toPair())

    return List(k) { pq.poll().first }
}

fun main() {
    println(topKFrequent(arrayOf("i","love","leetcode","i","love","coding"), 2))
    println(topKFrequent(arrayOf("the","day","is","sunny","the","the","the","sunny","is","is"), 4))
}
