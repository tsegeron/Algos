/*
    2965. Find Missing and Repeated Values
    https://leetcode.com/problems/find-missing-and-repeated-values/description/
 */

package leetcode.easy

fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val visited = IntArray(grid.size * grid[0].size + 1)
    val res = IntArray(2)

    grid.forEach { row ->
        row.forEach {
            if (visited[it] == 1)
                res[0] = it
            ++visited[it]
        }
    }

    for (i in 1..visited.size) {
        if (visited[i] == 0) {
            res[1] = i
            break
        }
    }

    return res
}
