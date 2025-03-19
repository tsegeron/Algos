/*
    Hash Table, String, Binary Search
    981. Time Based Key-Value Store
    https://leetcode.com/problems/time-based-key-value-store/description/
 */

package leetcode.medium

import java.util.TreeMap

private class TimeMap() {
    private val ts = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        ts.getOrPut(key) { mutableListOf() }.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        if (key !in ts)
            return ""

        val pairs = ts[key]
        var res = ""
        var l = 0
        var r = pairs!!.size - 1
        while (l <= r) {
            val mid = (l + r) / 2

            if (timestamp < pairs[mid].first)
                r = mid - 1
            else {
                res = pairs[l].second
                l = mid + 1
            }
        }

        return res
    }
}

// Not my solution, yet interesting, but without BS
private class TimeMap2() {
    private val hashMap = HashMap<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        hashMap.computeIfAbsent(key) { TreeMap() }[timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        return hashMap[key]?.floorEntry(timestamp)?.value ?: ""
    }
}

fun main() {
    val timeMap = TimeMap2()
    println(timeMap.set("foo", "bar", 1)) // store the key "foo" and value "bar" along with timestamp = 1.
    println(timeMap.get("foo", 1)) // return "bar"
    println(timeMap.get("foo", 3)) // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    println(timeMap.set("foo", "bar2", 4)) // store the key "foo" and value "bar2" along with timestamp = 4.
    println(timeMap.get("foo", 4)) // return "bar2"
    println(timeMap.get("foo", 5)) // return "bar2"
}
