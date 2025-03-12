package codewars

fun main() {
    var b = arrayOf("BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600")
    var c = arrayOf("A", "B", "C", "D")
    var res = "(A : 0) - (B : 1290) - (C : 515) - (D : 600)"
    println(StockList.stockSummary(b, c))
    println(StockList.stockSummary(b, c) == res)

    b = arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600")
    c = arrayOf("A", "B")
    res = "(A : 200) - (B : 1140)"
    println(StockList.stockSummary(b, c))
    println(StockList.stockSummary(b, c) == res)
}

object StockList {
    fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        if (lstOfCat.isEmpty() or lstOfArt.isEmpty()) {
            return ""
        }

        val result = lstOfCat.associateWith { 0 }.toMutableMap()

        lstOfArt.forEach { art ->
            val (name, count) = art.split(" ")

            val c = name.first().uppercase()
            if (c in result.keys)
                result[c] = result[c]!!.plus(count.toInt())
        }

        return result.map { "(${it.key} : ${it.value})" }.joinToString(" - ")
    }
}
