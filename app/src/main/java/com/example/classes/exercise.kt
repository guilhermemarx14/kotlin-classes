package com.example.classes

fun main() {
    /** testing the extension function toStringList() **/
    val myString = "My text"
    println(myString.toStringList()) // [M, y,  , t, e, x, t]

    /** testing the singleton UtilityHelper **/
    val util = UtilityHelper
    util.setCurrentDay(DayOfTheWeek.MONDAY)
    println(util.isWeekend()) // false

    val util2 = UtilityHelper
    util2.setCurrentDay(DayOfTheWeek.SUNDAY)
    println(util2.isWeekend()) // true - Using util instead of util2 does not change the output, they are the same object
}

/** Convert a String into a List of Strings containing each letter as a different String **/
fun String.toStringList(): List<String> {
    val mutableList: MutableList<String> = mutableListOf()
    for (i in this)
        mutableList.add(i.toString())

    return mutableList.toList()
}

/** Create an enum class to represent the days of the week **/
enum class DayOfTheWeek(value: String) {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday")
}

object UtilityHelper {
    private var currentDay = DayOfTheWeek.SUNDAY

    fun setCurrentDay(newDay: DayOfTheWeek) {
        this.currentDay = newDay
    }

    fun isWeekend(): Boolean {
        return when (this.currentDay) {
            DayOfTheWeek.SUNDAY -> true
            DayOfTheWeek.SATURDAY -> true
            else -> false
        }
    }
}
