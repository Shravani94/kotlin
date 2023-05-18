package com.example.entities

import com.example.models.Departments
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object departmentBind:Table<Departments>("departments"){
    val departid=int("departid").primaryKey().bindTo { it.departid }
    val departname=varchar("departname").bindTo { it.departname }
    val location=varchar("location").bindTo { it.location }
}