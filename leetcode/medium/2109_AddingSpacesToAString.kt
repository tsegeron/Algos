/*
    Array, Two Pointers, String, Simulation
    2109. Adding Spaces to a String
    https://leetcode.com/problems/adding-spaces-to-a-string/description/
 */

package leetcode.medium

private fun addSpaces(s: String, spaces: IntArray): String {
    val res = CharArray(s.length + spaces.size)

    var spacesPlaced = 0
    for (i in s.indices) {
        if (spacesPlaced < spaces.size && i == spaces[spacesPlaced])
            res[i + spacesPlaced++] = ' '
        res[i + spacesPlaced] = s[i]
    }

    return String(res)
}

private fun addSpaces2(s: String, spaces: IntArray): String = buildString(s.length + spaces.size) {
    append(s.slice(0..<spaces[0]))
    append(' ')

    for (i in 1..<spaces.size) {
        append(s.slice(spaces[i - 1]..<spaces[i]))
        append(' ')
    }
    append(s.slice(spaces.last()..<s.length))
}

fun main() {
    println(addSpaces("icodeinpython", intArrayOf(1,5,7,9)))
    println(addSpaces("LeetcodeHelpsMeLearn", intArrayOf(8,13,15)))
    println(addSpaces("spacing", intArrayOf(0,1,2,3,4,5,6)))
}
