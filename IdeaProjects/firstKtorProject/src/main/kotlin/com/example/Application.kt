package com.example

import com.example.model.Customer
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.routes.customerRouting
import com.tdl.motorinsurance.plugins.configureSerialization
import io.ktor.server.routing.*
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.from

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)

}

fun Application.module() {
    configureRouting()
    configureSerialization()
}

