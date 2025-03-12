/*
    Array, Two Pointers, Sorting
    15. 3Sum
    https://leetcode.com/problems/3sum/description/
 */

package leetcode.medium

private fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val sorted = nums.sorted()

    for (i in 0..(sorted.lastIndex - 2)) {
        if (sorted[i] > 0)
            break
        if (i > 0 && sorted[i] == sorted[i - 1])
            continue
        
        var l = i + 1
        var r = sorted.lastIndex

        while (l < r) {
            val sum = sorted[l] + sorted[r] + sorted[i]
            if (sum == 0) {
                result.add(listOf(sorted[i], sorted[l], sorted[r]))
                while (l < r && sorted[l] == sorted[l + 1])
                    l++
                while (l < r && sorted[r] == sorted[r - 1])
                    r--
                l++
                r--
            }
            else if (sum < 0)
                l++
            else
                r--
        }
    }
    return result
}

fun main() {
    val nums = intArrayOf(-1,0,1,2,-1,-4)

    println(threeSum(nums))
}
// -4,-1,-1,0,1,2
