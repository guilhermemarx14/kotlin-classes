package com.example.classes

fun main() {
    /** Creating a instance of NewPerson increments the counter in the companion object **/
    val person = NewPerson.createPerson() // equals to Person.Manager.createPerson()

    /** The companion's attributes and methods can be accessed by the NewPerson class as static **/
    println(NewPerson.counter) // 1 - equals to Person.Manager.counter

    val secondPerson =  NewPerson.createPerson()
    /** Number of instances of NewPerson (using the first instance) **/
    println(person.getTotalPerson()) // 2

    /** Calling the extension function helloPerson() from NewPerson class **/
    person.helloPerson() // Hello Test

    /** Calling the extension function decrementCounter() from the Manager class **/
    NewPerson.decrementCounter()
    println(NewPerson.counter) // 1

    /** Calling the extension function greetings() from the String class **/
    println(person.name.greetings(true)) // Hello Test, have a nice day!
}

fun String.greetings(isDay: Boolean) =
    "Hello $this, have a nice ${if (isDay) "day" else "evening"}!"


/** Extension function for NewPerson **/
fun NewPerson.helloPerson() = println("Hello ${this.name}")

/** Extension function for Manager **/
fun NewPerson.Manager.decrementCounter() {
    this.counter--
}

/** Private constructor guarantees only the companion object can access it **/
class NewPerson private constructor(var name: String, var email: String) {

    fun getTotalPerson(): Int = counter

    companion object Manager {
        var counter = 0

        fun createPerson(): NewPerson {
            counter++
            return NewPerson("Test", "test@test.com")
        }
    }
}