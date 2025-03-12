/*
    1738. Find Kth Largest XOR Coordinate Value
    https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/description
 */

package leetcode.medium

import java.util.PriorityQueue

private fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
    /*
     * Value in row[j] = row[0] ^ row[1] ^ ... ^ row[j]   (0 <= j < n)
     *
     * Example: row = [5,2,1,6] --> xorRow = [5,7,6,0]
     * 5 -> 5
     * 5^2 -> 7
     * 7^1 -> 6
     * 6^6 -> 0
     *
     */

    for (i in matrix.indices) {
        for (j in 1..matrix[0].lastIndex) {
            matrix[i][j] = matrix[i][j - 1].xor(matrix[i][j])
        }
    }

    val q = PriorityQueue<Int>()

    for (rowIndex in matrix.indices) {
        for (colIndex in matrix[0].indices) {
            val curXor = if (rowIndex == 0) {
                matrix[rowIndex][colIndex]
            } else {
                val res = matrix[rowIndex][colIndex].xor(matrix[rowIndex - 1][colIndex])
                matrix[rowIndex][colIndex] = res
                res
            }

            q.add(curXor)
            if (q.size > k)
                q.poll()
        }
    }

    return q.peek()
}

/*
    0 0 0 0
    0 0 0 0
    0 0 0 0
    0 0 0 0

  Initial      XOR
    5 2        5 7
    1 6        4 0

    5^2    5^1    5^2^1^6
    101    101    110
     10      1    101
    111    100     10
                    1
                    0

    (0,0) = 5
    (0,1) = 5^2 = 7
    (1,0) = 5^1 = 4
    (1,1) = 5^2^1^6 = 0
 */
fun main() {
//    kthLargestValue(arrayOf(intArrayOf(5,2,1,6)), 1)
    println(kthLargestValue(arrayOf(intArrayOf(5,2), intArrayOf(1,6)), 3))
}
