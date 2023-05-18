package com.example.entities

import com.example.models.Departments
import com.example.models.Employees
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object employeeBind:Table<Employees>("employees"){
    val empid=int("empid").primaryKey().bindTo { it.empid }
    val firstName=varchar("firstName").bindTo { it.firstName }
    val lastName=varchar("lastName").bindTo { it.lastName }
    val email=varchar("email").bindTo { it.email }
    val role=varchar("role").bindTo { it.role }
    val departid=int("departid").references(departmentBind){it.department}
}