package codewars

fun main() {
//    println(interpret(arrayOf("mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a")))
    println(interpret(arrayOf("mov a -10", "mov b a", "inc a", "dec b", "jnz a -2")))
}

private fun interpret(program: Array<String>): Map<String, Int> {
    val res = mutableMapOf<String, Int>()
    val cmds = program.map { it.split(" ") }

    var i = 0
    while (i < program.size) {
        val cmd = cmds[i][0]
        val reg = cmds[i][1] // .toIntOrNull() ?: res[cmds[i][1]]!!
        val num = if (cmd[0] == 'm' || cmd[0] == 'j')
            cmds[i][2].toIntOrNull() ?: res[cmds[i][2]]!!
        else 0

        when (program[i][0]) {
            'm' -> res[reg] = num
            'i' -> res[reg] = res[reg]!! + 1
            'd' -> res[reg] = res[reg]!! - 1
            'j' -> {
                val reg1 = reg.toIntOrNull() ?: res[cmds[i][1]]!!
                if (reg1 != 0)
                    i += num - 1
            }
        }
        i++
    }

    return res
}
