/*
    42. Trapping Rain Water
    Link: https://leetcode.com/problems/trapping-rain-water/description/
 */

package leetcode.hard

private fun trap(height: IntArray): Int {
    var start = 0
    var res = 0
    while (start < height.lastIndex && height[start] <= height[start + 1]) ++start

    fun getNextPeakIndex(curPeak: Int, startFrom: Int, height: IntArray): Int {
        if (curPeak == 0)
            return startFrom

        var nextPeakIndex = startFrom + 1

        while (nextPeakIndex < height.size) {
            if (height[nextPeakIndex] >= curPeak)
                return nextPeakIndex
            nextPeakIndex += 1
        }

        return getNextPeakIndex(curPeak - 1, startFrom, height)
    }

    var curPeak: Int
    while (start < height.size) {
        val nextPeakIndex = getNextPeakIndex(height[start], start, height)
        if (nextPeakIndex == start)
            break

        curPeak = minOf(height[start], height[nextPeakIndex])

        while (++start < nextPeakIndex)
            res += curPeak - height[start]
    }

    return res
}
