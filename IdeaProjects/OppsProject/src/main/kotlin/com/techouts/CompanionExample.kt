package com.techouts

class CompanionExample {
    companion object{
        fun dispaly():String{
            println("this is the companion function from class")
            return "companion method from class"
        }
    }
    fun view():String{
        println("this is the function from class with out companion object")
        return "hello"
    }
}
fun CompanionExample.Companion.show(){
    println("this is the function form out side the class")
}
fun main(agrs:Array<String>){
    var obj=CompanionExample.dispaly()
    println(obj)
    var obj2=CompanionExample.show()
    println(obj2)
    var obj3=CompanionExample()
    obj3.view()
}