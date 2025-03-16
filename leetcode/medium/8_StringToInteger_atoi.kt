/*
    String
    8. String to Integer (atoi)
    https://leetcode.com/problems/string-to-integer-atoi/description/
 */

package leetcode.medium

private fun myAtoi(s: String): Int {
    var i = 0
    var positive = 1

    while (i < s.length && s[i] == ' ')
        ++i

    if (i < s.length && s[i] in "-+")
        positive = if (s[i++] == '-') -1 else 1

    var res = 0
    while (i < s.length && s[i] in '0'..'9') {
        val digit = s[i++] - '0'

        if (res > (Int.MAX_VALUE - digit) / 10)
            return if (positive > 0) Int.MAX_VALUE else Int.MIN_VALUE

        res = res * 10 + digit
    }

    return res * positive
}
