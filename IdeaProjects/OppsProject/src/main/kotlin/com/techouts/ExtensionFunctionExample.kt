package com.techouts

class ExtensionFunctionExample {
    fun addition(num1:Int, num2:Int){
        var sum=num1+num2
        println("sum of two numbers is ${sum}")
    }
    fun subtraction(num1:Int,num2:Int){
        var sub=num1-num2
        println("subtraction of two numbers is $sub")
    }
}
fun ExtensionFunctionExample.swap(num1:Int,num2:Int){
    var div=num1/num2
    println("division of two numbers is $div")

}
fun main(args:Array<String>){
    val obj=ExtensionFunctionExample()
    obj.addition(23,12)
    obj.subtraction(34,12)
    obj.swap(213,34)

}