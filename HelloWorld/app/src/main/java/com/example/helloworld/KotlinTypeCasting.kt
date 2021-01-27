package com.example.helloworld

import kotlin.math.floor

fun main() {
    val stringList = listOf<String>("Hampus", "Hugo", "David", "Fredrik")
    val mixedList = listOf<Any>("John", 31, 5, "BDay", 40.6, "weighs", "kg")

    for (value in mixedList) {
        if (value is Int) {
            println("Integer: $value")
        }
        else if (value is Double) {
            println("Double: $value with floor value: ${floor(value)}")
        }
        else if (value is String) {
            println("String: $value of length: ${value.length}")
        }
        else {
            println("Unknown type")
        }
    }

    // Alternative using when (More concise and nice)
    for (value in mixedList) {
        when (value) {
            is Int -> println("Integer: $value")
            is Double -> println("Double: $value with floor value: ${floor(value)}")
            is String -> println("String: $value of length: ${value.length}")
            else -> println("Unknown type")
        }
    }

    // Smart casting
    val obj1: Any = "Hello there"
    if (obj1 !is String) {
        println("Object is not of type String")
    }
    else {
        // obj1 is automatically cast to a String in this scope
        println("String object is of length ${obj1.length}")
    }

    // Explicit (unsafe) casting
    val str1: String = obj1 as String
    println("This is perfectly okay $str1")

//    val obj2: Any = 1337
//    val str2: String = obj2 as String
//    println("This would cause problems $str2")
    /* We're trying to make a String out of an Any (which hides an Int).
    * Can go wrong, and it will in this case. We can't cast Int to String
    * */

    // Explicit (safe) casting using "as?"
    val obj3: Any = 1337
    val str3: String? = obj3 as? String
    println("This will at least work $str3")
    /*
    * Using the keyword "as?" will try to cast to the desired type
    * and if it fails it will return null. As we prepared for this
    * (setting str3 to a nullable variable) we safely got out of the
    * situation.
    * */

}