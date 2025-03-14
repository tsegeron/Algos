/*
    Array, Binary Search
    2226. Maximum Candies Allocated to K Children
    https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
 */

package leetcode.medium

private fun IntArray.isValid(amount: Int, aim: Long): Boolean {
    var res = 0L

    for (pile in this)
        res += pile / amount

    return res >= aim
}

private fun maximumCandies(candies: IntArray, k: Long): Int {
    var (l, r) = 1 to candies.max()
    var res = 0

    while (l <= r) {
        val mid = l + (r - l) / 2

        if (candies.isValid(mid, k))
            l = (mid + 1).also { res = mid }
        else
            r = mid - 1
    }

    return res
}
