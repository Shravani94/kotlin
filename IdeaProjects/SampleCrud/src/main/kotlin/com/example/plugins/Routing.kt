package com.example.plugins

import com.example.repository.SubRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    val totaldetails = SubRepository()
    val gson = Gson()
    val gsonbuild = GsonBuilder().setPrettyPrinting().create()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
