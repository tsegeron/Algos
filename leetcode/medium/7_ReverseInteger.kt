/*
    Math
    7. Reverse Integer
    https://leetcode.com/problems/reverse-integer/description/
 */

package leetcode.medium

private fun reverse(x: Int): Int {
    var num = x * if (x < 0) -1 else 1
    var res = 0

    while (num != 0) {
        val digit = num % 10

        if (res > (Int.MAX_VALUE - digit) / 10)
            return 0
        res = res * 10 + digit

        num /= 10
    }

    return res * if (x < 0) -1 else 1
}
