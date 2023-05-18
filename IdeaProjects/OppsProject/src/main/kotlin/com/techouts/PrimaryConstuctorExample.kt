package com.techouts

class PrimaryConstuctorExample(name:String,employeeId:Int) {
    //with out using initializer block
    val employeeName=name
    val id=employeeId
    fun display(){
        println("employee name is : $employeeName")
        println("employee is is : $id")
    }
    //using initializer blocks
    var nameoftheemployee="first proterty name $name".also(::println)
    init {
        println("name of the employee is :$name")
    }
    var nameLength="second proprty og the class ${name.length}".also(::println)
    init {
        println("length of the name is ${name.length}")
    }
}
fun main(Agrs:Array<String>){
    var obj=PrimaryConstuctorExample("Shravani",1994)
    obj.display()
}