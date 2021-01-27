package com.example.helloworld

fun main() {

    /*
    * Lambda are nameless functions, also known as anonymous functions.
    * They are function literals, i.e. functions that are not declared,
    * but passed immediately as an expression.
    *
    * We define lambdas within curly braces { } which can take variables
    *  as parameters. We always write the variable, if we have any,
    * before the function body. We separate the two with an arrow ->.
    *
    * Syntax:
    * { variable(s) -> body }
    */
    // Addition of two numbers:
    // Normal function:
    fun addNumber(a: Int, b: Int) {
        val sum = a + b
        println(sum)
    }

    addNumber(5, 3)

    // Lambda expression (long version)
    val sumLong: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    println(sumLong(5, 3))

    // Lambda expression (short version)
    val sumShort = { a: Int, b: Int -> println(a + b) }
    sumShort(5, 3)
}

