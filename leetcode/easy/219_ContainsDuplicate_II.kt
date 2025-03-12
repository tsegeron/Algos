package leetcode.easy

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val visited = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        if (nums[i] in visited && i - visited[nums[i]]!! <= k)
            return true
        visited[nums[i]] = i
    }

    return false
}
