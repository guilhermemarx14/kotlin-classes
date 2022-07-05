package com.example.classes

/** Main function **/
fun main() {
    /** Declaring the factory **/
    val factory = AbstractVehicleFactory()

    /** Creating a list of Vehicle with a car and a motorcycle**/
    val vehicleList: MutableList<AbstractVehicle> =
        mutableListOf(
            factory.vehicleFactory("Civic", 200, 10, true),
            factory.vehicleFactory("CG", 210, 5, false)
        )

    /** Accelerating every Vehicle on the list **/
    vehicleList.forEach { it.accelerate() }

    /** Printing every Vehicle on the console **/
    vehicleList.forEach { println(it) }
}

/** Declare a abstract class to represent a vehicle **/
abstract class AbstractVehicle(var modelName: String, var velocity: Long, var acceleration: Long) {

    /** Method for increasing speed **/
    fun accelerate() {
        velocity += acceleration
    }

    /** Method for decreasing speed **/
    fun brake() {
        velocity = if (velocity < acceleration) 0 else velocity - acceleration
    }

    /** Method for getting the current speed **/
    fun getCurrentVelocity() = velocity

    /** toString() method **/
    override fun toString() = "model: $modelName, velocity: $velocity, acceleration: $acceleration"
}

/** Declare a Car class to inherit the vehicle class **/
class Car(modelName: String, velocity: Long = 0, acceleration: Long = 10) :
    AbstractVehicle(modelName, velocity, acceleration) {

    override fun toString() = "Car " + super.toString()
}

/** Declare a Motorcycle class to inherit the vehicle class **/
class Motorcycle(modelName: String, velocity: Long = 0, acceleration: Long = 5) :
    AbstractVehicle(modelName, velocity, acceleration) {

    override fun toString() = "Motorcycle " + super.toString()

}

/** Create a Factory class for Vehicle **/
class AbstractVehicleFactory {
    fun vehicleFactory(
        modelName: String,
        velocity: Long,
        acceleration: Long, isCar: Boolean
    ): AbstractVehicle {
        return if (isCar) Car(modelName, velocity, acceleration) else Motorcycle(
            modelName,
            velocity,
            acceleration
        )

    }
}