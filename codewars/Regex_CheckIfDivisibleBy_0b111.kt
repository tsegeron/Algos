package codewars/*
    My level: 4 kyu
    Problem Level: 2 kyu

    Regular Expression - Check if divisible by 0b111 (7)
    https://www.codewars.com/kata/56a73d2194505c29f600002d/

    May help: recursion in regex, division of binary numbers
 */

const val multipleOf7 = """^1{3}0*$"""

private fun prods(num: Int) {
    for (i in num..num*21 step 14)
        println("${i/7}\t" + i.toString(2))
}

fun main() {
//    val reg = Regex(multipleOf7)
//
//    println("11110".contains(reg))
//    println("11110".matches(reg))


    prods(7)
//    (0..9).forEach { println("$it\t" + it.toString(2)) }
}
/* Example of 7*19 / 7:
    10000101|111
   -000     |010011
   =1000
    -111
    =001010
       -111
       =0111
        -111
          =0
 */
// "^1.....[01]$
/*
    "1{3}0*"    7 * [1,2,4,8,16,32,64]
    "101010*"   7 * [3,6,12]
    "1000110*"   7 * [5,10,20,40]

    "1110*111"  7 * [9,17,33,65]
 */

// [01] * [ 2^n + 2^(n-1) + .... + 2^4 + 2^3 + 2^2 + 2^1 + 2^0 ]
