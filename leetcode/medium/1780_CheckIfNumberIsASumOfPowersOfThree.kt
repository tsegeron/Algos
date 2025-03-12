/*
    Math
    1780. Check if Number is a Sum of Powers of Three
    https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/
 */

package leetcode.medium

private fun checkPowersOfThree(n: Int): Boolean {
    val powers = mutableListOf<Int>().apply {
        var prev = 1
        while (prev <= n)
            add(prev).also { prev *= 3 }
    }

    var rem = n
    for (i in powers.indices.reversed()) {
        if (rem < powers[i]) continue
        if (rem == 0) return true
        rem -= powers[i]
    }

    return rem == 0
}

fun main() {
    println(checkPowersOfThree(12))
    println(checkPowersOfThree(91))
    println(checkPowersOfThree(21))
}
