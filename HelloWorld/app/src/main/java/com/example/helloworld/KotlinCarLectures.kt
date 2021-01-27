package com.example.helloworld

fun main() {
    var rs6 = Car("RS6", "Audi", 250.0)
    var modelS = ElectricCar("Model S", "Tesla", 85.0, 200.0)

    rs6.drive(200.0)
    modelS.drive(200.0)
    modelS.extendRange(200.0)
    modelS.drive()
    modelS.brake()
}

// Interface
/*
* Allows us to create a baseline for our classes, which they can
* extend and modify.
*
* An interface gives the required fields and methods that a class
* which extends the interface needs to have. Methods can be empty,
* only having the header, or they can have a function body as well.
* The same goes for fields, which can have a default value or not.
* That value can be overridden in the class implementation.
* */
interface Drivable {
    val maxSpeed: Double
    fun drive(): String
    fun brake() {
        println("The drivable is braking")
    }
}

// Inheritance
/*
* Classes in Kotlin are final by default, which means that we cannot inherit
* without using the keyword open. This applies to all classes, even Child
* classes.
* */

// Car is a Super/Base/Parent class
open class Car(val name: String, val brand: String, override val maxSpeed: Double) : Drivable {
    // Properties
    open var range: Double = 0.0

    // Methods
    fun extendRange(amount: Double) {
        if (amount > 0) {
            range += amount
        }
    }

    open fun drive(distance: Double) {
        println("Drove for $distance km")
    }


    override fun drive(): String {
        return "Driving the interface drive"
    }
}

// Car is a Sub class/Child class/Derived class of Car
class ElectricCar(name: String, brand: String, batteryLife: Double, override val maxSpeed: Double)
    : Car(name, brand, maxSpeed) {

    var chargerType: String = "Type1"

    override var range = batteryLife * 5

    override fun drive(distance: Double) {
        println("Drove for $distance km on electricity")
    }

    override fun drive() : String {
        return "Drove for $range km on electricity"
    }

    // Here we choose to implement brake as a class-specific
    override fun brake() {
        super.brake()
        println("The electric car is breaking")
    }

}