/*
    Array, Sorting
    3169. Count Days Without Meetings
    https://leetcode.com/problems/count-days-without-meetings/description/
 */

package leetcode.medium

private fun countDays(days: Int, meetings: Array<IntArray>): Int {
    meetings.sortBy { it[0] }
    var res = meetings[0][0] - 1

    var maxEndIdx = 0
    var minStartIdx = 0
    for (i in 1..<meetings.size) {
        if (meetings[i][0] > meetings[maxEndIdx][1] + 1)
            res += meetings[i][0] - meetings[maxEndIdx][1] - 1
        if (meetings[i][0] < meetings[minStartIdx][0])
            minStartIdx = i
        if (meetings[i][1] > meetings[maxEndIdx][1])
            maxEndIdx = i
    }

    return res + days - meetings[maxEndIdx][1]
}
