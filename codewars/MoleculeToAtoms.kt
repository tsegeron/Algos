package codewars

import java.util.*

fun main() {
//    println(getAtoms("SO3"))
//    println(getAtoms("Mg(OH)2"))
//    println(getAtoms("K4[ON(SO3)2]2"))
//    println(getAtoms("[ON(SO3)2]2")) // 0=14, S=4, N=2 // [ON S2O6]2
//    println(getAtoms("ON(SO3)2")) // 0=7, S=2, N=1 // [ON S2O6]2
//    println(getAtoms("ON(SO3)2"))
//    println(getAtoms("pie"))
    println(getAtoms2("[(O2)4]2"))

//    println(getAtoms("(C5H5)Fe(CO)2CH3")) // {C=8, H=8, Fe=1, O=2} ... {H=3, C=1, O=2, Fe=1}
}

val bracketsMap = mapOf(')' to '(', '}' to '{', ']' to '[')

private fun getAtomsFromBrackets(formula: String, startIndex: Int? = null, stopBracket: Char? = null): Pair<Int, Map<String, Int>> {
    val res = mutableMapOf<String, Int>()
    var curFormula = ""
    var curCount = ""
    var curTotalLen = 0
    var i = startIndex ?: formula.lastIndex

    while (i >= 0) {
        ++curTotalLen
        when (formula[i]) {
            in 'A'..'Z' -> {
                curFormula = formula[i] + curFormula

                val count = curCount.toIntOrNull() ?: 1
                res[curFormula] = res.getOrDefault(curFormula, 0) + count

                curCount = ""
                curFormula = ""
            }
            in 'a'..'z' -> curFormula = formula[i] + curFormula
            in '0'..'9' -> curCount = formula[i] + curCount
            else -> when {
                stopBracket == null && formula[i] in bracketsMap.values -> throw IllegalArgumentException()
                stopBracket != null && formula[i] == stopBracket -> break
                formula[i] in bracketsMap.values -> {
                    val (len, formulaFromBrackets) = getAtomsFromBrackets(
                        formula = formula,
                        startIndex = i - 1,
                        stopBracket = bracketsMap[formula[i]],
                    )
                    i -= len
                    curTotalLen += len
                    val count = curCount.toIntOrNull() ?: 1
                    formulaFromBrackets.forEach { (key, value) ->
                        res[key] = res.getOrDefault(key, 0) + value * count
                    }
                    curCount = ""
                    curFormula = ""
                }
            }
        }
        --i
    }

    if (res.isEmpty() || stopBracket != null && i < 0)
        throw IllegalArgumentException()

    return Pair(curTotalLen, res)
}

private fun getAtoms(formula: String): Map<String, Int> {
    return getAtomsFromBrackets(formula).second
}

private fun getAtoms2(formula: String): Map<String, Int> {
    var str = formula
    val regex = Regex("""(\(\w+\)|\{\w+\}|\[\w+\])(\d*)""")
    while (regex.find(str) != null) {
        str = regex.replace(str, {it.groupValues[1].drop(1).dropLast(1).repeat(it.groupValues[2].toIntOrNull()?:1)})
    }
    if (str.any{it in "(){}[]"} || Regex("""[^A-Z][a-z]+""").find(str) != null) throw IllegalArgumentException()
    return Regex("""([A-Z][a-z]*)(\d*)""").findAll(str)
        .groupBy(keySelector={it.groupValues[1]},valueTransform={it.groupValues[2].toIntOrNull()?:1})
        .map{it.key to it.value.sum()}
        .toMap()
}

