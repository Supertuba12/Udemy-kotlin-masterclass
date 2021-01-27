package com.example.helloworld

import java.util.*

fun main() {
    // var name : String = "Hampus"
    var nullableName : String? = "Hugo"

    // Old way to check to nullable
    /*if  (nullableName != null) {
        var nullLength = nullableName.length
    } else {
        null
    }*/

    // New way in kotlin to check for nullable
    // var nullableLength = nullableName?.length

    // ?: is called the Elvis operator.
    // A non-nullable variable can take the value of a nullable variable
    // if the latter has a value at the time. Otherwise it will resolve to
    // a default value instead, for instance Guest in this case.
    val name = nullableName ?: "Guest"
    println(name)

    // This !!. operator is called the not null assertion. It converts
    // a nullable type to a non-nullable type. It will throw a NullTypeException
    // if the value is null, so use with care!
    val nullableName2 : String? = "Hugo"
    println(nullableName2!!.toLowerCase())

    // To only carry out an operation if the value is not null we can use
    // the let operator with the safe call ?.
    // nullableName?.let { println(it.toLowerCase()) }

}

fun shadowFunction(a : Int) {
    var a = 0
    // Which a is printed?
    println("a is $a")

    // Answer: the variable not the parameter a.

    /*
    * Explanation: Kotlin allows to "Shadow" variables. Which can be useful
    * to decouple my code from other parts of the system. This is possible
    * because names such as "a" are bound to the current scope.
    *
    * Try to avoid shadowing because it makes code difficult to read, i.e.
    * are you trying to use your variable or the parameter? Also, it makes it
    * impossible to access the parameter once you have shadowed it.
    * */


}