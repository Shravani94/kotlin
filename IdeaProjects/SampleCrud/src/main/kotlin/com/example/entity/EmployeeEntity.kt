package com.example.entity

import org.ktorm.schema.Table
import org.ktorm.schema.float
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object EmployeeEntity :Table<Nothing>("employees"){
    val empId=int("empId").primaryKey()
    val firstName=varchar("firstName")
    val lastName=varchar("lastName")
    val mailId=varchar("mailId")
    val location=varchar("location")
    val designation=varchar("designation")
    val salary=float("salary")
}