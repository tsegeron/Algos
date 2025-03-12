/*
    Array, Divide and Conquer, Greedy, Sorting, Quickselect
    324. Wiggle Sort II TODO
    https://leetcode.com/problems/wiggle-sort-ii/description/
 */

package leetcode.medium

/*
    1,5,1,1,6,4 --> 1,6,1,5,1,4
    1,3,2,2,3,1 --> 2,3,1,3,1,2

    k(i) > k(i+2), i:(i % 2 = 0) 0,2,4,...,2n
    k(j) > k(j+2), j:(j % 2 = 1) 1,3,5,...,2n+1
    descending order starting from index = 2n+1, n=0,1,2...
        until the end, then the rest from 2n, n=0,1,2...
    index can be represented as (2n+1) % if (n % 2 == 1) n else n + 1
        or as simplified as (2n+1) % if (n or 1)

    may be possible to sort directly in places?

    1.functions needed (with sorting):
        1. radixSort
        2. sortByDigit (for radix sort)

    2. functions needed (with median):
        1. swap
        2. some foo for index (maybe)
        3. quickSelect (to find median)
        4. partition (with randomizer for quickSelect)

 */

// ----------------------------------------------------------------------------
private fun wiggleSort1(nums: IntArray) {
    val numsSorted = nums.copyOf()
    val n = nums.size
    radixSort(numsSorted)

    for (i in numsSorted.indices)
        nums[i.get(n)] = numsSorted[i]
}

private fun radixSort(nums: IntArray) {
    val maxNum = nums.maxOrNull() ?: return
    var exp = 1

    while (maxNum / exp != 0) {
        sortByDigit(nums, exp)
        exp *= 10
    }
}

// descending order
private fun sortByDigit(nums: IntArray, exp: Int) {
    val count = IntArray(10)
    val res = IntArray(nums.size)

    for (num in nums)
        ++count[9 - num / exp % 10]

    for (i in 1..count.lastIndex)
        count[i] += count[i - 1]

    for (i in nums.indices.reversed()) {
        val digit = nums[i] / exp % 10
        res[--count[9 - digit]] = nums[i]
    }

    for (i in res.indices)
        nums[i] = res[i]
}

private fun Int.get(n: Int) = (1 + this * 2) % (n or 1)

// ----------------------------------------------------------------------------
/*
private fun wiggleSort2(nums: IntArray) {
    val median = quickSelect(nums, 0, nums.size - 1, nums.size / 2)

    val n = nums.size
    var l = 0
    var r = n - 1
    var i = 0
    while (i <= r) {
        val index = i.get(n)
        if (nums[index] < median) // lower goes right
            nums.swap(index, r--.get(n))
        else if (nums[index] > median) // higher goes left
            nums.swap(i++.get(n), l++.get(n))
        else
            ++i
    }
}

private fun quickSelect(nums: IntArray, l: Int, r: Int, k: Int): Int {
    if (l == r)
        return nums[l]

    val pivotIndex = partition(nums, l, r)

    return when {
        pivotIndex == k -> nums[pivotIndex]
        k < pivotIndex -> quickSelect(nums, l, pivotIndex - 1, nums.size / 2)
        else -> quickSelect(nums, pivotIndex + 1, r, nums.size / 2)
    }
}

private fun partition(nums: IntArray, left: Int, right: Int): Int {
    nums.swap(right, (left..right).random())
    var l = left
    val pivot = nums[right]

    for (i in left until right) {
        if (nums[i] < pivot)
            nums.swap(i, l++)
    }
    nums.swap(l, right)
    return l
}

private fun IntArray.swap(l: Int, r: Int) {
    this[l] = this[r].also { this[r] = this[l] }
}
*/

fun main() {
//    val nums = intArrayOf(5, 4, 3, 1, 0, 2)
//    val nums = intArrayOf(5, 4, 3, 1, 2)
//    val nums = intArrayOf(1,5,1,1,6,4, 10)
    val nums = intArrayOf(10,1,7,2,10,5,8,4,9,4,10,8,8,1,5,6,8,9,2,1)
//    val nums = intArrayOf(4,5,5,6)

    wiggleSort1(nums)
//    wiggleSort2(nums)
//    radixSort(nums)

    println(nums.toList())
}
