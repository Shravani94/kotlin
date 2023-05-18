package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Department:Entity<Department> {
    val dept_no:Int
    val dept_name:String
    val dept_head:String
    val no_faculty:Int
}
object Departments:Table<Department>("departments"){
    val dept_no=int("dept_no").primaryKey().bindTo { it.dept_no }
    val dept_name=varchar("dept_name").bindTo { it.dept_name }
    val dept_head=varchar("dept_head").bindTo { it.dept_head }
    val no_faculty=int("no_faculty").bindTo { it.no_faculty }

}