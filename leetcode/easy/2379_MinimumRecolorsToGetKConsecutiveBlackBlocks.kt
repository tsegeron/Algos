package leetcode.easy

private fun minimumRecolors(blocks: String, k: Int): Int {
    var min = Int.MAX_VALUE
    var curWCount = 0
    var l = 0

    for (i in blocks.indices) {
        if (blocks[i] == 'W')
            ++curWCount
        if (i - l >= k && blocks[l++] == 'W')
            --curWCount
        if (i - l + 1 == k) {
            min = minOf(min, curWCount)
            if (min == 0)
                break
        }
    }

    return min
}
