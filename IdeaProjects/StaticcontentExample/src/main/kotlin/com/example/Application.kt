package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val port = environment.config.propertyOrNull("ktor.properties.name")?.getString() ?: "shravani" +
    ""
    routing {
        static("/") {
            staticBasePackage = "static"
            resource("index.html")
            defaultResource("index.html")
            static("images") {
                resource("ktor_logo.png")
                resource("image.png", "ktor_logo.png")
            }
            static("assets") {
                resources("css")
                resources("js")
            }
        }
        get("/show"){
            call.respondText("name is $port")
        }

    }
}