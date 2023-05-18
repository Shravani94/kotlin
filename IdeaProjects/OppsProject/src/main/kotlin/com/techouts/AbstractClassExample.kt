package com.techouts

abstract class AbstractClassExample {
    abstract fun run(meters: Int)
    fun walk(meters:Int){
        println("you walked $meters")
    }
}