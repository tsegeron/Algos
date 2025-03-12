package codewars

fun main() {

}

private fun persistence(num: Int) : Int {
    var strNum = num.toString()
    var count = 0

    while (strNum.length > 1) {
        strNum = strNum.fold(1) { acc, c -> acc * c.digitToInt() }.toString()
        count++
    }

    return count
}
