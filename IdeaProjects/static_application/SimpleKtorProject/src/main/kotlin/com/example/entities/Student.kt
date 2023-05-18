package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Student: Entity<Student> {
    val roll_no:Int
    val first_name:String
    val last_name:String
    val mail_id:String
    val dept_no:Int
    val department:Department
}
object Students:Table<Student>("students"){
    val roll_no=int("roll_no").primaryKey().bindTo { it.roll_no }
    val first_name=varchar("first_name").bindTo { it.first_name }
    val last_name=varchar("last_name").bindTo { it.last_name }
    val mail_id=varchar("mail_id").bindTo { it.mail_id }
    val dept_id=int("dept_id").references(Departments) {it.department}
}