package codewars

private fun generateCombinations(
    ls: List<Int>,
    k: Int,
    start: Int,
    currentList: List<Int>,
    result: MutableList<List<Int>>
) {
    if (currentList.size == k) {
        result.add(currentList)
        return
    }

    for (i in start until ls.size) {
        generateCombinations(ls, k, i + 1, currentList + ls[i], result)
    }
}

private fun combinationsOfSizeK(ls: List<Int>, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    generateCombinations(ls, k, 0, mutableListOf(), result)
    return result
}

private fun chooseBestSum(t:Int, k:Int, ls:List<Int>):Int {
    if (ls.size < k) return -1

    return combinationsOfSizeK(ls, k).map(List<Int>::sum).filter { it <= t }.maxOrNull() ?: -1
}


fun main() {
//    println(chooseBestSum(163, 3, listOf(50, 55, 56, 57, 58))) // 163
    println(chooseBestSum(163, 3, listOf(150, 155, 156, 157, 158))) // 163
//    println(chooseBestSum(230, 3, listOf(91, 74, 73, 85, 73, 81, 87))) // 228
}
