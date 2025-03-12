package codewars/*
    My level: 5 kyu
    Problem Level: 3 kyu

    One line task: Is the King in check? (In kotlin should be <280 characters)
    https://www.codewars.com/kata/5e320fe3358578001e04ad55

    Ideas:  1. convert to a whole string
                1.a. use regex
                    1.a.1. with [get all indices of diagonal | orthodox and join + relative indices of knight] --- (~500 chars)
                    1.a.2. with [relative positions] (does not work)
            2. convert to a whole string with 7 spaces after each row
                2.a regex with [relative positions] (~350 chars + problems with Rook)
            3. convert to a whole string with 7 spaces after each row + row.reversed
                3.a regex with [relative positions] (solves, 277 chars, can be reduced)
 */

// Solution: 277 characters
private fun isCheck(b:Array<Array<String>>)=b.joinToString(""){it.joinToString("")+"       "+it.joinToString("").reversed()+"       "}.contains(Regex("♟.{30}♔|♞(.{31}|.{60})♔|♔(.{31}|.{60})♞|[♜♛](.{29} )*.{29}♔|♔(.{29} )*.{29}[♜♛]|[♜♛] {0,6}♔|[♝♛](.{30} )*.{30}♔|♔(.{30} )*.{30}[♝♛]"))

fun main() {
    val boardTest = arrayOf(
        arrayOf("♔","♛","♜","♝","♞","♟"," "," "),
        arrayOf(" "," "," "," "," "," "," "," "),
        arrayOf(" "," "," "," "," "," "," "," "),
        arrayOf(" "," "," "," "," "," "," "," "),
        arrayOf(" "," "," "," "," "," "," "," "),
        arrayOf(" "," "," "," "," "," "," "," "),
        arrayOf(" "," "," "," "," "," "," "," "),
        arrayOf(" "," "," "," "," "," "," "," "))

    println(isCheck(boardTest))
}

/* Extended version for understanding

fun isCheckDetailed(b:Array<Array<String>>)=b.joinToString(""){it.joinToString("")+"       "+it.joinToString("").reversed()+"       "}.let { f ->
    val pawn = "♟.{30}♔"
    val knight = "♞(.{31}|.{60})♔|♔(.{31}|.{60})♞"
    val rook = "[♜♛](.{29} )*.{29}♔|♔(.{29} )*.{29}[♜♛]|[♜♛] {0,6}♔"
    val bishop = "[♝♛](.{30} )*.{30}♔|♔(.{30} )*.{30}[♝♛]"

    f.contains(Regex(pawn)) || f.contains(Regex(knight)) || f.contains(Regex(rook)) || f.contains(Regex(bishop))
}
*/
