/*
    Hash Table, Linked List, Design, Doubly-Linked List
    460. LFU Cache
    https://leetcode.com/problems/lfu-cache/description/
 */

package leetcode.hard

/* Leetcode does not compile for some reason
private class LFUCache(private val capacity: Int) {

    // key to (value, frequency)
    private val hashMap = HashMap<Int, Pair<Int, Int>>(capacity)
    // frequency to List<key> (for the keys with the same frequency)
    private val hashMapOfEqualFrequencies = HashMap<Int, LinkedHashSet<Int>>(capacity)
    private var curSize = 0

    fun get(key: Int): Int {
        if (key !in hashMap) return -1

        val used = hashMap.compute(key) { _, p -> p!!.first to p.second + 1}
        hashMapOfEqualFrequencies[used!!.second - 1]?.remove(key)
        if (hashMapOfEqualFrequencies[used.second - 1].isNullOrEmpty())
            hashMapOfEqualFrequencies.remove(used.second - 1)
        hashMapOfEqualFrequencies.computeIfAbsent(used.second) { LinkedHashSet() }.addFirst(key)

        return used.first
    }

    fun put(key: Int, value: Int) {
        if (curSize >= capacity) {
            val keyToDelete = hashMapOfEqualFrequencies[hashMapOfEqualFrequencies.keys.min()]?.removeLast()
            hashMap.remove(keyToDelete)
            --curSize
        }

        val used = hashMap.compute(key) { _, p -> Pair(value, (p?.second ?: 0) + 1) }
        hashMapOfEqualFrequencies[used!!.second - 1]?.remove(key)
        if (hashMapOfEqualFrequencies[used.second - 1].isNullOrEmpty())
            hashMapOfEqualFrequencies.remove(used.second - 1)
        hashMapOfEqualFrequencies.computeIfAbsent(used.second) { LinkedHashSet() }.addFirst(key)
        ++curSize
    }
}
*/

private class LFUCache(private val capacity: Int) {
    private val key2val = HashMap<Int, Int>(capacity) // key to value
    private val key2freq = HashMap<Int, Int>(capacity) // key to frequency
    private val freq2key = HashMap<Int, LinkedHashSet<Int>>(capacity) // frequency to List<key> (for the keys with the same frequency)
    private var curSize = 0

    fun get(key: Int): Int {
        if (key !in key2val) return -1

        key2freq[key] = key2freq[key]!! + 1
        freq2key[key2freq[key]!! - 1]?.remove(key)
        if (freq2key[key2freq[key]!! - 1].isNullOrEmpty())
            freq2key.remove(key2freq[key]!! - 1)
        freq2key.computeIfAbsent(key2freq[key]!!) { LinkedHashSet() }.add(key)

        return key2val[key]!!
    }

    fun put(key: Int, value: Int) {
        if (key in key2val) {
            val freq = key2freq[key]!!
            key2val[key] = value
            key2freq[key] = freq + 1
            freq2key[freq]?.remove(key)
            if (freq2key[freq].isNullOrEmpty())
                freq2key.remove(freq)
            freq2key.computeIfAbsent(freq + 1) { LinkedHashSet() }.add(key)
            return
        }

        if (curSize >= capacity) {
            val minFreq = freq2key.keys.min()
            val keyToDelete = freq2key[minFreq]?.first()

            key2val.remove(keyToDelete)
            key2freq.remove(keyToDelete)
            freq2key[minFreq]!!.remove(keyToDelete)
            if (freq2key[minFreq].isNullOrEmpty())
                freq2key.remove(minFreq)
            --curSize
        }

        key2val[key] = value
        key2freq[key] = 1
        freq2key.computeIfAbsent(1) { LinkedHashSet() }.add(key)
        ++curSize
    }
}

fun main() {
//    val lfu = LFUCache(2)
//    println(lfu.put(1, 1))
//    println(lfu.put(2, 2))
//    println(lfu.get(1))
//    println(lfu.put(3, 3))
//    println(lfu.get(2))
//    println(lfu.get(3))
//    println(lfu.put(4, 4))
//    println(lfu.get(1))
//    println(lfu.get(3))
//    println(lfu.get(4))
//    val lfu = LFUCache(2)
//    println(lfu.put(3, 1))
//    println(lfu.put(2, 1))
//    println(lfu.put(2, 2))
//    println(lfu.put(4, 4))
//    println(lfu.get(2))
}
