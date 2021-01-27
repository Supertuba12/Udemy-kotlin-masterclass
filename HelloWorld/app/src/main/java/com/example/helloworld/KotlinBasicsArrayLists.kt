package com.example.helloworld

fun main() {

    // There are three ways to instantiate an ArrayList
    // 1 - Create an empty ArrayList
    val myArr1: ArrayList<Double> = ArrayList()
    // 2 - Create an ArrayList with a specified capacity
    val myArr2: ArrayList<Int> = ArrayList(10)
    // 3 - Create an ArrayList filled with elements from a Collection
    val myCollection = listOf("elem1", "elem2", "elem3")
    val myArr3: ArrayList<String> = ArrayList(myCollection)
    // Note that all ArrayLists are instantiated using val.
    // We cannot change the ArrayList object but we can modify its contents

    // ArrayLists have some built-in functionality such as
    // 1 - Adding stuff
    myArr1.add(1.0)
    // 2 - Clear a list of all its elements
    myArr1.clear()
    // 3 - Get an element from a specified index
    val elemAtIndex = myArr3.get(0)
    // 4 - Removing stuff, if available
    val isRemoved = myArr2.remove(0)

    // ArrayLists also have iterators
    val itr = myArr3.iterator()

    while (itr.hasNext()) {
        println(itr.next())
    }

    println("Size of array: ${myArr3.size}")

    val exerciseArray = ArrayList<Double>()
    exerciseOne(exerciseArray)
}

// Exercise
fun exerciseOne(arr: ArrayList<Double>) {
    arr.add(Math.random())
    arr.add(Math.random())
    arr.add(Math.random())
    arr.add(Math.random())
    arr.add(Math.random())

    var tot = 0.0
    for (num in arr) {
        tot += num
    }

    val avg = tot / arr.size
    println("Average is: $avg")
}
