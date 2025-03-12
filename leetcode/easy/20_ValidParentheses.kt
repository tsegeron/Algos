import java.util.*

private fun isValid(s: String): Boolean {
    val brackets = mapOf('(' to ')', '{' to '}', '[' to ']')
    var stack = Stack<Char>()

    for (c in s) {
        if (c in brackets)
            stack.push(brackets[c])
        else if (stack.isEmpty() || stack.pop() != c)
            return false
    }
    return stack.isEmpty()
}
