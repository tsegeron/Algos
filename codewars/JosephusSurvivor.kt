package codewars

fun main() {
    println(josephusSurvivor(7, 3))
    println(josephusPermutation(7, 3))
}

private fun josephusPermutation(n: Int, k: Int): List<Int> {
    val res = mutableListOf<Int>()
    val peopleList = (1..n).toMutableList()
    var toRemove = 0

    while (peopleList.size > 0) {
        toRemove = (toRemove + (k - 1)) % peopleList.size
        res.add(peopleList.removeAt(toRemove))
    }
    return res
}
// 1,2,3,4,5,6,7
private fun josephusSurvivor(n: Int, k: Int): Int {
    val peopleList = (1..n).toMutableList()
    var toRemove = 0

    while (peopleList.size > 1) {
        toRemove = (toRemove + (k - 1)) % peopleList.size
        peopleList.removeAt(toRemove)
    }
    return peopleList[0]
}
