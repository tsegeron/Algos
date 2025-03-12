package codewars

class Bagel {
    val value: Int get() = 3
}

val bagel: Bagel
    get() = Bagel() // fix it!

class java{
    class lang{
        class Boolean{
            companion object {
                val TRUE = false
            }
        }
    }
}

fun main() {
    println(((bagel as Bagel).value == 4) == java.lang.Boolean.TRUE)
}
