package com.techouts

class Humans:Livingthings {
    override fun move(){
        println("human can drive vehicles for moving")
    }

    override fun stay() {
        println("humans will stay in homes")
    }

    override fun eat() {
        println("they will eat different food items")
    }
}