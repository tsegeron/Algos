/*
    Array, Sorting
    3394. Check if Grid can be Cut into Sections
    https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/
 */

package leetcode.medium

private class Solution3394 {
    private fun isValid(rectangles: Array<Pair<Int, Int>>): Boolean {
        rectangles.sortWith(compareBy { it.first })

        var maxEndIdx = 0
        var res = 0
        for (i in 1..<rectangles.size) {
            if (rectangles[i].first >= rectangles[maxEndIdx].second) {
                maxEndIdx = i
                ++res
            } else if (rectangles[i].second > rectangles[maxEndIdx].second) {
                maxEndIdx = i
            }
        }
        return res >= 2
    }

    fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
        val verticals = Array(rectangles.size) { Pair(rectangles[it][1], rectangles[it][3]) }
        val horizontals = Array(rectangles.size) { Pair(rectangles[it][0], rectangles[it][2]) }

        return isValid(verticals) || isValid(horizontals)
    }
}
