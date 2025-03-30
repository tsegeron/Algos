/*
    Design, Heap (Priority Queue), Data Stream, Ordered Set
    2102. Sequentially Ordinal Rank Tracker
    https://leetcode.com/problems/sequentially-ordinal-rank-tracker/description/
 */

package leetcode.hard

import java.util.*

private class SORTracker() {
    private val minHeap = PriorityQueue(compareBy<Pair<Int, String>> { it.first }.thenBy { it.second })
    private val maxHeap = PriorityQueue(compareByDescending<Pair<Int, String>> { it.first }.thenByDescending { it.second })

    fun add(name: String, score: Int) {
        minHeap.add(score to name)
        maxHeap.add(minHeap.poll())
    }

    fun get(): String = maxHeap.poll().let {
        minHeap.add(it)
        it.second
    }
}
