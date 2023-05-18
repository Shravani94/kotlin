package com.example.entities

import com.example.models.Employees
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object employee:Table<Employees>("employee"){
    val empid=int("empid")
    val firstName=varchar("firstName")
    val lastName=varchar("lastName")
    val email=varchar("email")
    val role=varchar("role")
    val departid=int("departid")
}