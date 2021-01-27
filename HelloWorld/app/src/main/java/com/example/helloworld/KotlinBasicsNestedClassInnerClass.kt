package com.example.helloworld


/* Nested Classes
* A nested class is created inside another class, without using the
* keyword inner as a prefix. In kotlin a nested class is by default
* static and so its members can be accessed without having to create
* an object of the class. The nested class cannot access the data
* members of the outer class
* */
class OuterClassNested {

    private var name: String = "Hampus"

    class NestedClass {

        var description: String = "Nested class"
        private var id: Int = 100

        fun tryPrint() {
            // println("name is $name")
            // Cannot access outer class data members!
            println("ID is $id")
        }
    }
}

/* Inner Class
* The inner class is essentially a nested class marked with the
* keyword inner. The main difference between the two is that an
* inner class cannot be declared inside an interface or non-inner
* nested classes.
*
* The advantage over nested classes is that inenr classes can still
* access members of its outer class even if they are private.
* */

class OuterClassInner() {

    private var name: String = "Hampus"

    inner class InnerClass {

        var description: String = "Inner class"
        private var id: Int = 100

        fun tryPrint() {
            println("name is $name")
            println("ID is $id")
        }
    }
}

fun main() {

    // Accessing the data and function member of the nested class
    // without creating the class
    println(OuterClassNested.NestedClass().description)
    OuterClassNested.NestedClass().tryPrint()

    // We can of course create an object and access them too
    var obj = OuterClassNested.NestedClass()
    println(obj.description)
    obj.tryPrint()

    // When calling tryPrint for the inner class we can print the
    // private variable name of the outer class
    println(OuterClassInner().InnerClass().description)
    OuterClassInner().InnerClass().tryPrint()

    // We still can make an object
    var obj2 = OuterClassInner().InnerClass()
    println(obj2.description)
    obj2.tryPrint()

}