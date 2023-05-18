package com.techouts

open class InheritPropertyExample {
    open var name="Shravani"
    open val mailId="Sravani@gmail.com"
    open val employeeNo=1994
    open fun showDetails(){
        println("From super class")
        println("name of the employee $name")
        println("mailId of the employee $mailId")
        println("employee id of the employee $employeeNo")
    }
}