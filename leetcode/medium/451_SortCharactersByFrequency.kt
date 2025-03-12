/*
    Hash Table, String, Sorting, Heap (Priority Queue), Bucket Sort, Counting
    451. Sort Characters By Frequency
    https://leetcode.com/problems/sort-characters-by-frequency/description/
 */

package leetcode.medium

import java.util.PriorityQueue

fun frequencySortMap(s: String): String {
    val frequencies = mutableMapOf<Char, Int>()
    val pq = PriorityQueue(compareByDescending<Pair<Char, Int>> { it.second })

    s.forEach { frequencies[it] = frequencies.getOrDefault(it, 0) + 1 }

    frequencies.forEach { pq.add(it.toPair()) }

    var res = StringBuilder()
    while (pq.isNotEmpty())
        res.append(pq.poll().let { it.first.toString().repeat(it.second) })

    return res.toString()
}

fun frequencySortArray(s: String): String {
    val frequencies = IntArray(75)
    s.forEach { ++frequencies[it - '0'] }

    val pairs = frequencies.mapIndexed { c, count -> Pair('0' + c, count) }
    val pq = PriorityQueue<Pair<Char, Int>>(pairs.size, compareByDescending { it.second }).apply { addAll(pairs) }

    return buildString {
        while (pq.isNotEmpty())
            append(pq.poll().let { it.first.toString().repeat(it.second) })
    }
}
