package com.example.plugins

import com.example.CustomPrincipal
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.get

fun Application.configureRouting() {
    routing {
        authenticate("auth-digest") {
            get("/digest") {
                call.respondText("Hello, ${call.principal<CustomPrincipal>()?.userName}!")
            }
        }
            authenticate("auth-bearer") {
                get("/bearer") {
                    call.respondText("Hello, ${call.principal<UserIdPrincipal>()?.name}!")
                }
            }
        }
    }
