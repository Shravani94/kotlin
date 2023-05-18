package com.example.plugins

import com.example.service.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import kotlinx.serialization.builtins.serializer

fun Application.configureRouting() {
    routing {
        route("create") {
            post("/insertData") {
                val body = call.receive<StudentDTO>()
                val response = insertData(body)
                call.respond(response)
            }
        }
        route("getting") {
            get("/getWithRequestBody") {
                val body = call.receive<StudentDTO>()
                val allStudents = getAllstudent(body)
                call.respond(allStudents)
            }
            get("/getWithParam") {
                val student = getWithParam()
                call.respond(student)
            }
            get("/getWithQuery") {
                val student = getWithQueryParam()
                call.respond(student)
            }

        }
        route("update"){
            put("/updateWithRequestBody"){
                val body=call.receive<StudentDTO>()
                val updatemessage= updatewithRequestBody(body)
                call.respond(updatemessage)
            }
            put("/updateWithQuery"){
                val body=call.receive<StudentDTO>()
                val updatemessage= updateWithQueryParam(body)
                call.respond(updatemessage)
            }
        }
        route("/delete") {
            delete("/delete") {
                val body = call.receive<StudentDTO>()
                val updatemessage = deleteData(body)
                call.respond(updatemessage)
            }
        }
    }
}
