package com.example.entities

import com.example.models.Departments
import com.example.models.Employees
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object department:Table<Departments>("departments"){
    val departid=int("departid").primaryKey()
    val departname=varchar("departname")
    val location=varchar("location")
}