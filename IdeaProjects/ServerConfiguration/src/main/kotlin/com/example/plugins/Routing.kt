package com.example.plugins

import com.example.model.Customer
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.util.*
import kotlinx.css.Color
import kotlinx.css.html
import kotlinx.html.*
import java.util.ArrayList

fun Application.configureRouting() {
    val storage=ArrayList<Customer>()
    routing {
        get("/string") {
            val data=call.receive<String>()
            call.respond(data)
            call.respondRedirect("/customers", permanent = true)
        }
        get("/customers"){
            val list1=call.receive<Customer>()
            storage.add(list1)
            call.respondRedirect("/htmlPage", permanent = true)


        }
        get("/") {
            call.response.header(HttpHeaders.ETag, "7c876b7e")
        }
        get("/custom") {
            call.response.header("Custom-Header", "Some value")
        }
        get("/redirect") {
            call.respondRedirect("/customers", permanent = true)
        }
        get("/htmlPage") {
            val formParameters=call.receiveParameters()
            val name=formParameters["username"].toString()?:"shravani"
            val password=formParameters["password"].toString()?:"sravani@123"
            call.respondText("my name is $name and password is $password")
            call.respondHtml(HttpStatusCode.OK) {
                body {
                    p {
                        +"name is $name"
                    }
                    p{
                        +"password is $password"
                    }
                }
            }
        }
        get("/login") {
            call.respondHtml {
                body {
                    form(action = "/htmlPage", encType = FormEncType.applicationXWwwFormUrlEncoded, method = FormMethod.get) {
                        p {
                            +"Username:"
                            textInput(name = "username")
                        }
                        p {
                            +"Password:"
                            passwordInput(name = "password")
                        }
                        p {
                            submitInput() { value = "Login" }
                        }
                    }
                }
            }
        }
    }

}
