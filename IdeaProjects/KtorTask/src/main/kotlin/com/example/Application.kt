package com.example

import com.example.entities.Student
import com.example.model.StudentDTO
import io.ktor.server.application.*
import com.example.plugins.*
import com.example.router.getstudent
import com.example.router.studentRouter
import com.example.router.updateStudentRouter
import io.ktor.server.auth.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.requestvalidation.*
import org.ktorm.database.Database

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)
var connection:Database?=null

@Suppress("unused")
fun Application.module() {
    install(DefaultHeaders){
        header("name","admin")
        header("password","admin")
    }
    install(Authentication) {
        basic("auth-basic") {
            realm = "Access to the '/' path"
            validate { credentials ->
                if (credentials.name == "admin" && credentials.password == "admin") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
    install(RequestValidation) {
        validate<Student> { student ->
            if (student.id <= 0)
                ValidationResult.Invalid("A customer ID should be greater than 0")
            else ValidationResult.Valid
        }
    }

    configureSerialization()
    configureSecurity()
    configureRouting()
    studentRouter()
    getstudent()
    updateStudentRouter()

    connection = DatabaseFactory.init()

}
