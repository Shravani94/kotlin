package com.techouts

class NestedClass {
        var name:String="shravani"
        class nestedClass{
            var id:Int=10;
            fun innerFunction(){
                println("this is nested class function ")
                println("id = $id")
            }
        }

    }
fun main(agrs:Array<String>){
    println(NestedClass().name)
    var obj=NestedClass.nestedClass()
    obj.innerFunction()

}
