package com.example

import com.example.model.Customer
import com.example.plugins.configureRouting
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.ratelimit.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import kotlin.time.Duration.Companion.seconds

fun main() {
    embeddedServer(Netty, port = 9080) {
        install(RequestValidation) {
            validate<String> { bodyText ->
                if (!bodyText.startsWith("Hello"))
                    ValidationResult.Invalid("Body text should start with 'Hello'")
                else ValidationResult.Valid
            }
            validate<Customer> { customer ->
                if (customer.id <= 0)
                    ValidationResult.Invalid("A customer ID should be greater than 0")
                else ValidationResult.Valid
            }
            validate {
                filter { body ->
                    body is ByteArray
                }
                validation { body ->
                    check(body is ByteArray)
                    val intValue = String(body).toInt()
                    if (intValue <= 0)
                        ValidationResult.Invalid("A value should be greater than 0")
                    else ValidationResult.Valid
                }
            }
        }
        install(StatusPages) {
            exception<RequestValidationException> { call, cause ->
                call.respond(HttpStatusCode.BadRequest, cause.reasons.joinToString())
            }
        }
        install(ContentNegotiation) {
            json()
        }
       /* install(RateLimit){
            rateLimiter(limit = 5, refillPeriod = 60.seconds)
        }*/

        configureRouting()

    }.start(wait = true)
}

