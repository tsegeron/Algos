/*
    Array, Math, Design, Data Stream, Prefix Sum
    1352. Product of the Last K Numbers
    https://leetcode.com/problems/product-of-the-last-k-numbers/description/
 */

package leetcode.medium

private class ProductOfNumbers {

    private var prefixProds = arrayListOf(1)
    private var size = 0

    fun add(num: Int) {
        if (num == 0) {
            size = 0
            prefixProds = arrayListOf(1)
        }
        else
            prefixProds.add(num * prefixProds[size++])
    }

    fun getProduct(k: Int): Int =
        if (k > size) 0 else prefixProds[size - k + 1] / prefixProds[size - k]

}
