package com.example.router

import com.example.model.StudentDTO
import com.example.services.StudentService
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import kotlinx.serialization.builtins.serializer

fun Application.studentRouter() {
    val studentService = StudentService()
    routing {
        authenticate("auth-basic") {
            post("/insert") {
                val studentObj = call.receive<StudentDTO>()
                val noofRowsAffetcred = studentService.insertStudent(studentObj)
                if (noofRowsAffetcred > 0) {
                    call.respond("student details added successfully")
                } else {
                    call.respond("insertion unsuccessfull")
                }
            }
            /**************************delete data from table******************/

            delete("/remove") {
                val id = call.receive<StudentDTO>()
                val updatedrows = studentService.deleteById(id)
                if (updatedrows > 0) {
                    call.respond("deleted successfully")
                } else {
                    call.respond("unsuccessfully deleted")
                }
            }
        }
    }
}
