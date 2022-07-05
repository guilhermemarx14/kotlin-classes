/** Main function **/
fun main (){
    /** Declaring the factory **/
    val factory = InterfaceVehicleFactory()

    /** Creating a list of Vehicle with a car and a motorcycle**/
    val vehicleList: MutableList<InterfaceVehicle> =
        mutableListOf(
            factory.vehicleFactory("Civic", 200, 10, true),
            factory.vehicleFactory("CG", 210, 5, false)
        )

    /** Accelerating every Vehicle on the list **/
    vehicleList.forEach { it.accelerate() }

    /** Printing every Vehicle on the console **/
    vehicleList.forEach { println(it) }
}


interface InterfaceVehicle {
    var modelName: String
    var velocity: Long
    var acceleration: Long

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

}

class Car(
    override var modelName: String,
    override var velocity: Long = 0,
    override var acceleration: Long = 10
) :
    InterfaceVehicle {
    /** toString() method **/
    override fun toString() =
        "Car model: $modelName, velocity: $velocity, acceleration: $acceleration"

}

class Motorcycle(
    override var modelName: String,
    override var velocity: Long = 0,
    override var acceleration: Long = 5
) :
    InterfaceVehicle {
    /** toString() method **/
    override fun toString() =
        "Motorcycle model: $modelName, velocity: $velocity, acceleration: $acceleration"
}

/** Create a Factory class for Vehicle **/
class InterfaceVehicleFactory {
    fun vehicleFactory(
        modelName: String,
        velocity: Long,
        acceleration: Long, isCar: Boolean
    ): InterfaceVehicle {
        return if (isCar) Car(modelName, velocity, acceleration) else Motorcycle(
            modelName,
            velocity,
            acceleration
        )
    }
}