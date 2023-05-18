package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import com.example.routers.customerRouting
import org.ktorm.database.Database

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)
var connection: Database? = null

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    customerRouting()
    configureRouting()
}
