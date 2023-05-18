package com.example.models

import me.liuwj.ktorm.entity.Entity
interface Employees:Entity<Employees> {
    val empid:Int
    val firstName:String
    val lastName:String
    val email:String
    val role:String
    val departid:Int
    val department:Departments
}