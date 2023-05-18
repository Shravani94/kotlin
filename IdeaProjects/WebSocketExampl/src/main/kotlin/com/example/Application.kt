package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import kotlinx.serialization.Serializable

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)
@Serializable
data class Customer(val id: Int, val firstName: String, val lastName: String)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSockets()
    configureSerialization()
    configureRouting()
}
