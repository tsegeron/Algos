package leetcode.easy

private fun isPalindrome(s: String): Boolean =
    s.filter { it.isLetterOrDigit() }.let { it.equals(it.reversed(), true) }
