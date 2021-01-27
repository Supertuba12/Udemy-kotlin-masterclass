package com.example.helloworld

/*
* Visibility Modifiers, or Access Modifiers, are used to restrict
* the use of classes, interfaces, methods, and properties.
*
* We have
* four types of modifiers which we can use:
* 1. public - Can be accessed anywhere in the project, DEFAULT
* 2. private - Can only be accessed where it is declared
* 3. protected - makes members visible only to its
* class or subclass. You cannot specify a package as protected,
* i.e. you cannot mark a class or interface protected.
* 4. internal - Kotlin specific. makes fields visible only inside
* the module in which they are declared
*
* There are also keywords:
* 1. open - must be used to make a class inheritable
*
* */

// Public (public does not need to be used since default)
public class Public() {

    public val x = 1

    public fun doPublicStuff() {}

}

// Private
private class Private() { // Only accessible in the file

    private val y = 1 // Only accessible in the class

    private fun doPrivateStuff() {} // Only accessible in the class

}

// Protected
open class Protected() {

    protected open val z = 1 // Can be overridden (explicit open)
    protected val u = 2 // Cannot be overridden (default final)
}

class Derived() : Protected() {

    override val z = 2

    fun getProtectedValue(): Int {
        return u
    }
}

// Internal
internal class Internal() {

    internal val v = 1 // visible in the module

    internal fun doInternalStuff() {}
}