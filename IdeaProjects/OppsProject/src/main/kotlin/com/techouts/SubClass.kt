package com.techouts

class SubClass:AbstractClassExample() {
    override fun run(meters:Int) {
        println("you are run $meters")
    }
}
fun main(args:Array<String>){
    val obj=SubClass()
    obj.run(300)
    obj.walk(500)
}