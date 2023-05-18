package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
    module1()
    module2()
}
fun Application.module1(){
    routing {
        get("/module1"){
            application.log.info("this is module1 text")
            call.respondText("this is from module1")
        }
    }
}
fun Application.module2(){
    routing {
        get("/module2"){
            call.respondText("this is module1 text")
        }
    }
}
