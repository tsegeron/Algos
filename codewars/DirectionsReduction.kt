package codewars

fun main() {
    println(dirReduc(arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST")).joinToString(" "))
    println(dirReduc(arrayOf("NORTH", "WEST", "SOUTH", "EAST")).joinToString(" "))
    println(dirReduc(arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH")).joinToString(" "))
    println(dirReduc(arrayOf("NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH")).joinToString(" "))
    println(dirReduc(arrayOf("")).joinToString(" "))
}

private fun dirReduc(arr: Array<String>): Array<String> {
    val dirMap = mapOf("NORTH" to "SOUTH", "SOUTH" to "NORTH", "EAST" to "WEST", "WEST" to "EAST")
    val stack = mutableListOf<String>()

    arr.forEach {
        if (stack.lastOrNull()?.equals(dirMap[it]) == true)
            stack.removeLast()
        else
            stack.add(it)
    }

    return stack.toTypedArray()
}
