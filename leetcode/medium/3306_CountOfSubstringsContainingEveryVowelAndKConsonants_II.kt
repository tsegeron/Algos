/*
    Hash Table, String, Sliding Window
    3306. Count of Substrings Containing Every Vowel and K Consonants II
    https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/
 */

package leetcode.medium

private fun countOfSubstrings(word: String, k: Int): Long {
    val vowels = mutableMapOf('a' to 0, 'e' to 0, 'i' to 0, 'o' to 0, 'u' to 0)
    var cons = 0
    var res = 0L
    var leadingVowels = 0

    var l = 0
    for (i in word.indices) {
        val char = word[i]

        if (char in vowels)
            vowels[char] = vowels[char]!! + 1
        else
            ++cons

        while (cons > k) {
            if (word[l] in vowels)
                vowels[word[l]] = vowels[word[l]]!! - 1
            else
                --cons
            ++l
            leadingVowels = 0
        }

        while (cons == k && word[l] in vowels && 0 !in vowels.values && vowels[word[l]]!! > 1) {
            ++leadingVowels
            vowels[word[l]] = vowels[word[l]]!! - 1
            ++l
        }

        if (cons == k && 0 !in vowels.values)
            res += 1 + leadingVowels
    }

    return res
}

fun main() {
    println(countOfSubstrings("aoaiuefi", 1)) // 4
    println(countOfSubstrings("ieaouqqieaouqq", 1)) // 3
}
