package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import com.example.routes.departmentRouting
import com.example.routes.employeeRouting

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureRouting()
    departmentRouting()
    employeeRouting()
}
