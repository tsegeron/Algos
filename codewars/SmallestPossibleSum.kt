package codewars

fun main() {
    println(solution2(longArrayOf(6,9,21)))
    println(solution2(longArrayOf(1,21,55)))
    println(solution2(longArrayOf(3,13,23,7,83)))
    println(solution2(longArrayOf(71,71,71,71,71,71,71,71,71,71,71,71,71)))
    println(solution2(longArrayOf(11,22)))
    println(solution2(longArrayOf(5,17)))
    println(solution2(longArrayOf(4,16,24)))
    println(solution2(longArrayOf(9)))
}

private fun solution(numbers: LongArray): Long {
    while (numbers.toSet().size != 1) {
        if (numbers.contains(1))
            return numbers.size.toLong()
        numbers.sort()
        for (i in 1..numbers.lastIndex) {
            val rem = numbers[i] % numbers[0]
            numbers[i] = if (rem != 0L) rem else numbers[0]
        }
    }

    return numbers.first() * numbers.size.toLong()
}


private tailrec fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
private fun solution2(numbers: LongArray): Long {
    return numbers.size * numbers.reduce(::gcd)
}
