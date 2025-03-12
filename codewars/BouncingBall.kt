package codewars

fun main() {
    println(bouncingBall(3.0, 0.66, 1.5))
    println(3 == bouncingBall(3.0, 0.66, 1.5))
    println(bouncingBall(30.0, 0.66, 1.5))
    println(15 == bouncingBall(30.0, 0.66, 1.5))

}

private fun bouncingBall(h:Double, bounce:Double, window:Double):Int {
    if (h <= 0 || window >= h || bounce <= 0 || bounce >= 1)
        return -1

    return generateSequence(h) { it * bounce }.takeWhile { it > window }.count() * 2 - 1
}
