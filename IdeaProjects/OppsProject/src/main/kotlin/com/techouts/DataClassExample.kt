package com.techouts

data class DataClassExample(var emp_name:String,var emp_mail:String,var mobile:Long)
fun main(agrs:Array<String>){
    var obj=DataClassExample("shravani","sravani@gmail.com",9876543210)
    var obj1=DataClassExample("ruksan","rusana@gmail.com",7890654322)
    var obj2=obj.copy()
    var obj3=obj1.copy(emp_mail = "rukku@gmail.com")
    println("data")
    println(obj)
    println(obj1)
    println()
    println("using copy function")
    println(obj2)
    println(obj3)
    println()
    println("equals function and hashcode")
    println(obj.equals(obj2))
    println(obj1==obj3)
}