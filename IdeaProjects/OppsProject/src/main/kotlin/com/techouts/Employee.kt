package com.techouts

class Employee():InheritPropertyExample() {
    override val employeeNo: Int
        get() = 1897
    override val mailId: String
        get() = "Rukku@gmail.com"
    override var name: String
        get() = "Ruksana"
        set(value) {}

    override fun showDetails() {
        println("sub class details")
        println("name of the employee $name")
        println("mailId of the employee $mailId")
        println("employee id of the enpmloyee $employeeNo")

    }
}
fun main(args:Array<String>){
    println("execution strats")
    var obj1=InheritPropertyExample()
    println()
    obj1.showDetails()
    println()
    var obj2=Employee()
    obj2.showDetails()
    println()
    println("execution ends")
}