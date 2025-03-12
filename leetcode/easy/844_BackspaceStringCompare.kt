package leetcode.easy

/*
    844. Backspace String Compare
    https://leetcode.com/problems/backspace-string-compare/description/
 */

fun backspaceCompare(s: String, t: String): Boolean {
    var si = s.lastIndex
    var ti = t.lastIndex

    fun foo(start: Int, str: String): Int {
        var skip = 0
        var i = start

        while (i >= 0) {
            if (str[i] == '#')
                ++skip
            else if (skip > 0)
                skip--
            else
                break
            --i
        }
        return i
    }

    while (si >= 0 || ti >= 0) {
        si = foo(si, s)
        ti = foo(ti, t)

        if (si < 0 && ti < 0) return true
        if (si < 0 || ti < 0) return false
        if (s[si] != t[ti]) return false

        --si
        --ti
    }

    return true
}

fun main() {
    println(backspaceCompare("ab#c", "ad#c"))
    println(backspaceCompare("ab##", "c#d#"))
    println(backspaceCompare("xywrrmp", "xywrrmu#p"))
    println(backspaceCompare("a", "aa#a"))
}
