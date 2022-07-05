package com.example.classes

fun main() {
    val season = Season.FALL

    println(season) // FALL
    println(season.translate) // outono
    season.hello() // Hello winter

    when (season){
        Season.WINTER -> println("It's winter")
        Season.SPRING -> println("It's spring")
        Season.FALL -> println("It's fall")
        Season.SUMMER -> println("It's summer")
        /** No need for else because we are already testing all possibilities **/
    }
}

enum class Season(val translate: String) {
    WINTER("inverno"){
        override fun hello() = println("Hello winter")
                     },
    SPRING("primavera"){
        override fun hello() = println("Hello spring")
    },
    SUMMER("verão"){
        override fun hello() = println("Hello summer")
    },
    FALL("outono"){
        override fun hello() = println("Hello fall")
    };

    abstract fun hello()
}