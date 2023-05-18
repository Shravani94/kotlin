package com.example.service

import com.example.databaseconnection.DatabaseConnecetion
import com.example.entitybinding.employees
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

fun Application.inserting(){
    val db=DatabaseConnecetion.database
    routing {
        route("/custome"){
            post("/insert"){
                val customerDetails=call.receive<com.example.dataclass.Employee>()
                val id=customerDetails.empId;
                val firstname=customerDetails.firstName
                val lastName=customerDetails.lastName
                val mail=customerDetails.mailId
                val location=customerDetails.location
                val designation=customerDetails.designation
                val salary=customerDetails.salary
                db.insert(employee){
                    set(it.emp_id,id)
                    set(it.emp_first_name,firstname)
                    set(it.emp_last_name,lastName)
                    set(it.emp_mail,mail)
                    set(it.emp_designation,designation)
                    set(it.emp_location,location)
                    set(it.emp_salary,salary)
                }
            }
        }
    }
}