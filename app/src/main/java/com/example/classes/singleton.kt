package com.example.classes

/** Main Function **/
fun main() {
    /** Using the singleton class **/
    SchedulerHandler.currentSeason() // WINTER
    SchedulerHandler.setSeason(Season.SUMMER)
    SchedulerHandler.currentSeason() // SUMMER

    /** The value of the Singleton changes **/
    val anotherClass = AnotherClass()
    SchedulerHandler.currentSeason() // FALL
}

/** Change the value in the Singleton on instanciation **/
class AnotherClass {
    init {
        SchedulerHandler.setSeason(Season.FALL)
    }
}

/** Singleton class
 * Using enum class Season **/
object SchedulerHandler {
    private var season = Season.WINTER

    fun setSeason(newSeason: Season) {
        this.season = newSeason
    }

    fun currentSeason() = println(season)
}