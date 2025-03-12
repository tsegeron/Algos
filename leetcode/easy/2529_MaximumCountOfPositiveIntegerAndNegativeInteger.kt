package leetcode.easy

private fun binarySearch(nums: IntArray, min: Boolean = false): Int {
    var (l, r) = 0 to nums.size - 1
    var res = if (min) nums.size else -1

    while (l <= r) {
        val pivot = l + (r - l) / 2

        if (min) {
            if (nums[pivot] <= 0)
                l = pivot + 1
            else {
                res = pivot
                r = pivot - 1
            }
        } else {
            if (nums[pivot] < 0) {
                res = pivot
                l = pivot + 1
            } else {
                r = pivot - 1
            }
        }
    }

    return if (min) nums.size - res else res + 1
}

private fun maximumCount(nums: IntArray): Int {
    return maxOf(binarySearch(nums), binarySearch(nums, true))
}

fun main() {
    println(binarySearch(intArrayOf(-2,-1,-1,0,0,0)))
    println(binarySearch(intArrayOf(-2,-1,-1,1,2,3)))
    println(binarySearch(intArrayOf(-3,-2,-1,0,0,1,2)))
    println(binarySearch(intArrayOf(5,20,66,1314)))

    println(binarySearch(intArrayOf(-2,-1,-1,0,0,0), true))
    println(binarySearch(intArrayOf(-2,-1,-1,1,2,3), true)) // 1
    println(binarySearch(intArrayOf(-3,-2,-1,0,0,1,2), true))   // 1
    println(binarySearch(intArrayOf(5,20,66,1314), true)) // 5
}
