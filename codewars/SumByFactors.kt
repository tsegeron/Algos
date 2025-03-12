package codewars
fun main() {
    println(sumOfDivided(intArrayOf(12, 15)))
//    println(sumOfDivided(intArrayOf(15, 21, 24, 30, 45)))
}

private fun sumOfDivided(l: IntArray): String {
    fun Int.isPrime(): Boolean {
        for (i in 2 until this) {
            if (this % i == 0)
                return false
        }
        return true
    }

    val max = l.maxOrNull() ?: return ""
    val primes = (2..max).filter(Int::isPrime)
    val res = mutableListOf<Pair<Int, Int>>()

    for (prime in primes) {
        var curSum = 0
        var wasChanged = false

        for (num in l) {
            if (num % prime == 0) {
                wasChanged = true
                curSum += num
            }
        }
        if (wasChanged)
            res.add(Pair(prime, curSum))
    }

    return res.joinToString("") { "(${it.first} ${it.second})" }
}
