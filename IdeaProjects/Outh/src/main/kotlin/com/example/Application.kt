package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.http.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(Compression) {
        gzip {
            priority = 1.0
            matchContentType(
                ContentType.Application.Json
            )
        }
        deflate {
            priority = 0.9
            matchContentType(
                ContentType.Text.Any
            )
        }
    }
    routing {
        get("/") {
            call.respondText("Hello, world!")
        }
    }

}
