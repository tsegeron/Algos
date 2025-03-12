/*
    Array, Sliding Window
    3208. Alternating Groups II
    https://leetcode.com/problems/alternating-groups-ii/description/
 */

package leetcode.medium

private fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
    var count = 0
    var l = 0

    for (i in 1..colors.size - 1 + k) {
        if (colors[(i - 1) % colors.size] == colors[i % colors.size])
            l = i
        else if (i - l + 1 == k) {
            ++count
            ++l
        }
    }

    return count
}
