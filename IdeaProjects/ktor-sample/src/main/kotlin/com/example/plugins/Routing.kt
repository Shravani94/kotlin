package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.util.*

fun Application.configureRouting() {
    routing {
            get("/html-freemarker") {
                call.respond(FreeMarkerContent("Register.ftl", null))

            }

        get("/hello") {
            val formParamters=call.receiveParameters()
            val firstName=formParamters.getOrFail("firstname")
            val lastName=formParamters.getOrFail("lastname")
            call.respond("""firstName is $firstName
                |lastName  is $lastName
            """.trimMargin()  )

        }
    }
}
data class IndexData(val items: List<Int>)

