/*
    Array, Hash Table, String, Sorting
    49. Group Anagrams
    https://leetcode.com/problems/group-anagrams/description/
 */

package leetcode.medium

/* Exceeds Time Limit
private fun groupAnagrams(strs: Array<String>): List<List<String>> =
    strs.map { c ->
        strs.filter { s ->
            c.groupBy { it } == s.groupBy { it }
        }
    }.distinct()
*/

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val res = mutableMapOf<String, List<String>>()

    for (str in strs) {
        val cur = MutableList(26) { 0 }

        str.forEach { cur[it - 'a']++ }

        res[cur.toString()] = res.getOrDefault(cur.toString(), listOf()) + str
    }

    return res.values.toList()
}

fun main() {
    val strs = arrayOf("eat","tea","tan","ate","nat","bat")
//    val strs = arrayOf("ddddddddddg","dgggggggggg")

    println(groupAnagrams(strs))
}
