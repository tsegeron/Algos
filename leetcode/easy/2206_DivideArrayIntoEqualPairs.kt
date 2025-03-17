package leetcode.easy

import java.util.BitSet

private fun divideArray(nums: IntArray): Boolean {
    val res = Array<Long>(8) { 0 }

    for (num in nums) {
        val i = num / 64
        res[i] = res[i] xor (1L shl (num % 64))
    }

    return res.all { it == 0L }
}

private fun divideArray2(nums: IntArray): Boolean {
    val bitSet = BitSet(501)

    for (num in nums)
        bitSet.flip(num)

    return bitSet.isEmpty
}

fun main() {
    println(divideArray2(intArrayOf(3,2,3,2,2,2)))
}
