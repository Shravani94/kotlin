package com.example.routes

import com.example.dbconfiguration.DatabaseConnection
import com.example.entities.departmentBind
import com.example.entities.employee
import com.example.entities.employeeBind
import com.example.models.Department
import com.example.models.Employee
import com.example.models.Employees
import com.example.repositories.EmployeRepo
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.*

fun Application.employeeRouting(){
    val data=DatabaseConnection.database
    routing {
        route("/employee"){
            post("/addEmployee"){
                val emp=call.receive<Employee>()
                val id=emp.empid
                val first=emp.firstName
                val last=emp.lastName
                val email=emp.email
                val role=emp.role
                val dId=emp.departid

                println()

                data.insert(employeeBind){
                    set(it.empid,id)
                    set(it.firstName,first)
                    set(it.lastName,last)
                    set(it.email,email)
                    set(it.role,role)
                    set(it.departid,dId)
                }

                call.respondText("employee details inserted successfully")
            }
            get("/showAllEmployees"){
                val employees=data.from(employee).joinReferencesAndSelect().map { row ->employee.createEntity(row, withReferences = true)  }
                println("employees are $employees")
                call.respondText(employees.toString())
            }
            get("/show"){
                call.respond(EmployeRepo.get)
            }
        }
    }
}