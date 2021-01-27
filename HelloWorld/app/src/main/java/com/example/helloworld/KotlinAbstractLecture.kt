package com.example.helloworld


/* Abstract Classes
*
* Abstract classes are a type of class which cannot be instantiated.
* They are supposed to be inherited by Child/Sub/Derived classes which
* in turn can be instantiated instead.
*
* By default the fields and methods of an abstract class will be not be
* marked as abstract. That is something you need to do on your own. Marking
* a field or method as abstract means that they won't have a value and body
* respectively and must be overridden in the Sub class-
* */

abstract class Mammal(private val name: String, private val origin: String,
        private val weight: Double) { // Concrete (Non Abstract) Properties

    // Abstract property (Must be overridden by Sub Class
    abstract var maxSpeed: Double

    // Abstract Methods (Must be implemented by Sub Class)
    abstract fun run()
    abstract fun breath()


    fun displayDetails() {
        println("Name: $name, " +
                "Origin: $origin, " +
                "Weight: $weight kg, " +
                "Max speed: $maxSpeed km/h")
    }

}

class Human(name: String, origin: String, weight: Double,
        override var maxSpeed: Double) : Mammal(name, origin, weight) {

    override fun run() {
        println("Runs on two legs")
    }

    override fun breath() {
        println("Breaths through the mouth and nose")
    }

}

class Elephant(name: String, origin: String, weight: Double,
        override var maxSpeed: Double) : Mammal(name, origin, weight) {

    override fun run() {
        println("Runs on four legs")
    }

    override fun breath() {
        println("Breaths through the trunk")
    }
}

fun main() {
    val comrade = Human("Dimitri", "Russia", 80.0, 20.0)
    val elephant = Elephant("Dumbo", "Africa", 1000.0, 40.0)

    comrade.displayDetails()
    comrade.run()
    comrade.breath()

    elephant.displayDetails()
    elephant.run()
    elephant.breath()
}