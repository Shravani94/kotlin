package com.techouts

class Duck:Livingthings {
    override fun move(){
        println("duck will swim for moving in water")
    }

    override fun stay() {
        println("duck will stay in water")
    }

    override fun eat() {
        println("it will is fish in water")
    }
}
fun main() {
    var obj = Humans()
    obj.eat()
    obj.move()
    obj.stay()
    var obj1 = Duck()
    obj1.eat()
    obj1.move()
    obj1.stay()
    var obj2:Livingthings=Duck()
    obj2.eat()
}
