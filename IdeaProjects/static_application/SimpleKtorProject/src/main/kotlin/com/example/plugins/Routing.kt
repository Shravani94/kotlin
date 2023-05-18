package com.example.plugins

import com.example.dbconfig.configureStudentRouting
import com.example.routers.configureDepartmentRouting
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    configureDepartmentRouting()
    configureStudentRouting()
}
