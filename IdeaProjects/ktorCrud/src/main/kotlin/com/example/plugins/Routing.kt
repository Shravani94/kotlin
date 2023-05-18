package com.example.plugins

import com.example.Customer
import com.example.dao
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        route("/customers"){
            get {
                call.respond(dao.getAllEmployees())
            }
            post {
                val emp = call.receive<Customer>()
                dao.createEmployee(emp.firstName, emp.mailId, emp.lastName)
            }
            put {
                val emp = call.receive<Customer>()
                dao.updateEmployee(emp.id, emp.firstName, emp.mailId, emp.lastName)
            }
            delete("/{id}") {
                val id = call.parameters["id"]
                if(id != null)
                    dao.deleteEmployee(id.toInt())
            }
        }
    }

}
