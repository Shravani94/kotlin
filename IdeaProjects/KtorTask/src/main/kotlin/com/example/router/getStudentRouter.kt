package com.example.router

import com.example.model.StudentDTO
import com.example.services.StudentService
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.getstudent() {
    val studentService = StudentService()
    routing {
        authenticate("auth-basic") {

            /*******get all students*********/
            get("/students") {
                val studentsData = studentService.getAllStudents()
                call.respond(studentsData)
            }
            get("/studentsWithrequestbody") {
                val student = call.receive<StudentDTO>()
                val name = student.name ?: toString()
                val id = student.id.toInt() ?: "0".toInt()
                val students = studentService.getByIdOrName(id, name)
                if (students != null) {
                    if (students.size > 0)
                        call.respond(students)
                    else
                        call.respond("no student found with this details")
                }
            }
            get("/studentwithName/{name?}") {
                val name = call.parameters["name"] ?: null
                val students = name?.let { it1 -> studentService.getByName(it1) }
                if (students != null) {
                    if (students.size > 0)
                        call.respond(students)
                    else
                        call.respond("details or not found")
                }
            }
            get("/studentwithId/{id?}") {
                val id = call.parameters["id"]?.toInt() ?: "0".toInt()
                val students = id?.let { it1 -> studentService.getById(it1) }
                if (students != null) {
                    if (students.size > 0)
                        call.respond(students)
                    else
                        call.respond("details or not found")
                }
            }
            get("/studenname") {
                val id = call.request.queryParameters["id"]?.toInt() ?: "0".toInt()
                val name = call.request.queryParameters["name"]?: toString()
                val students = id?.let { it1 -> studentService.getByIdOrName(it1,name) }
                if (students != null) {
                    if (students.size > 0)
                        call.respond(students)
                    else
                        call.respond("details not found")
                }

            }
        }
    }
}


