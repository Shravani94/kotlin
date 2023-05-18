package com.example.routes

import com.example.dbconfig.database
import com.example.model.Customer
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.database.Database

fun Route.customerRouting(){
    var customerStorage = mutableListOf<Customer>()
    route("/customer"){
        get("/getCustomer") {
            if (customerStorage.isNotEmpty()) {
                call.respond(customerStorage)

            } else {
                call.respondText("No customers found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val customer =
                customerStorage.find { it.id.equals(id) } ?: return@get call.respondText(
                    "No customer with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(customer)
        }
      post("/saveCustomer") {
            val customer = call.receive<Customer>()
          println(customer)
           customerStorage.add(customer)
           // call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
          call.respond(customerStorage)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (customerStorage.removeIf { it.id.equals(id) }) {
                call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }


    }
    }
