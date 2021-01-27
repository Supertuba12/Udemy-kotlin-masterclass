package com.example.helloworld

import java.lang.IllegalArgumentException

fun main() {
    var myself = Person("Hampus", "Eriksson", 42)
    myself.stateHobby()

    var templatePerson = Person()
    var almostTemplatePerson = Person(_lastName = "Peterson")


    // Exercise 1
    var sammy = MobilePhone("Android", "Samsung", "Galaxy S21 Ultra")
    sammy.chargeBattery(30)
//    var huwie = MobilePhone("Android", "Huawei", "P40 Pro")
//    var appleBoi = MobilePhone("iOS", "Apple", "iPhone 13 Max")

    val user1 = User(1, "Hampus")
    val user2 = User(2, "Hugo")

    println(user1.equals(user2))

    println(user2.toString())

    val user3 = user1.copy(id = 3)

}

class Person(_firstName: String = "John", _lastName: String = "Doe") {
    // Member variables/property
    var firstName: String
    var lastName: String
    var age: Int? = null
    var hobby: String? = null

    // Initializer block. Used to setup our object
    init {
        this.firstName = _firstName
        this.lastName = _lastName
        println("Person $firstName $lastName created")
    }

    // Member secondary Constructor
    constructor(firstName: String, lastName: String, _age: Int)
            : this(firstName, lastName) {
                this.age = _age
            }

    // Member Functions/Methods
    fun stateHobby() {
        val myHobby = hobby ?: "doing nothing"
        println("$firstName says: My hobby is $myHobby")
    }
}

// Exercise 1
class MobilePhone(osName: String, brand: String, model: String) {

    private var battery = 50

    init {
        println("$brand $model running $osName created")
    }

    fun chargeBattery(totalCharge: Int) {
        println("Battery status before charge: $battery%")
        battery += totalCharge
        println("Battery status after charge: $battery%")
        println("Battery charged by: $totalCharge%")
    }
}

// lateinit and custom setter and getter
class SportsCar() {
    lateinit var owner : String

    val brand : String = "BMW"
        // Custom getter
        get() {
            return field.toLowerCase()
        }

    var maxSpeed : Int = 250
        // Custom setter
        set(value) {
            field = if (value > 0) value else throw IllegalArgumentException("maxSpeed cannot be negative")
        }

    /*
    * The default getter and setter that Kotlin always creates looks like this
    *   get() { field }
    *   set(value) { field = value }
    * This works fine for most cases, however as in our maxSpeed case we need to
    * do additional checks on the value before we set. And in the brand case we
    * want to print the string in a different manner.
    * */

    var myModel : String = "M5"
        private  set

    /*
    * A private setter can not be reached outside of the class. So in this case
    * you would not be able to change the value of the variable.
    * */

    init {
        owner = "Frank"
    }
}

// Data classes
/*
* Primary constructor must have at least one parameter. This type of class
* cannot be abstract, open, sealed or inner classes.
*
* Parameters can be either val or var, depending on your use case
*
* data classes have a equals method and a toString function. It also has a
* copy method.
*
* Sometimes we don't want a class with all the overhead and might only need
* the very basic functions. That's why data classes are useful since they can
* give us a quick and easy way to create objects.
* */
data class User(val id: Long, val name: String)

