package com.example.router

import com.example.model.StudentDTO
import com.example.services.StudentService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.updateStudentRouter(){
    val studentService=StudentService()
    routing {
        put("/updatestudents") {
            val students = call.receive<StudentDTO>()
            val name = students.name ?: toString()
            val id = students.id.toInt() ?: "0".toInt()
            val dataupadte = studentService.updateByNameOrId(students,id,name)
            if (dataupadte > 0) {
                call.respond("updated successfully")
            } else {
                call.respond("update failed")
            }
        }
        put("/updatestudentsWithQuery") {
            val students = call.receive<StudentDTO>()
            val id = call.request.queryParameters["id"]?.toInt() ?: "0".toInt()
            val name = call.request.queryParameters["name"]?: toString()
            val dataupadte = studentService.updateByNameOrId(students,id,name)
            if (dataupadte > 0) {
                call.respond("updated successfully")
            } else {
                call.respond("update failed")
            }
        }
    }
}