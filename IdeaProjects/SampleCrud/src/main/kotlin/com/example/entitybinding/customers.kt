package com.example.entitybinding

import com.example.dataclass.Employee
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.float
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar


object employees: Table<Employee>("employee"){
    val empId=int("empId").primaryKey().bindTo { it.empId }
    val firstName=varchar("firstName").bindTo { it.firstName}
    val lastName=varchar("lastName").bindTo { it.lastName }
    val mailId=varchar("mailId").bindTo { it.mailId }
    val designation=varchar("designation").bindTo {it.designation }
    val location=varchar("location").bindTo { it.location }
    val salary=float("salary").bindTo { it.salary }
}