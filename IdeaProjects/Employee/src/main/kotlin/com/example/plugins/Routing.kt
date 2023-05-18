package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.schema.ColumnDeclaring


fun Application.configureRouting() {
    val data = DatabaseConnection.database
    routing {
        get("/insert") {
            val empdetails = call.receive<EmployeeDTO>()
            val empId = empdetails.id
            val empName = empdetails.name
            val empMail = empdetails.mail

            println("$empId $empName $empMail")
            try {
                data.useTransaction {
                    data.insert(employe) {
                        set(it.id, empId)
                        set(it.name, empName)
                        set(it.mail, empMail)
                    }
                    call.respond("success")
                }
            } catch (e: DummyException) {
                println("insertion unsuccessful")

            }
        }
        get("/show") {

            val response = data.from(employe).select().map { row ->
                employe.createEntity(row)
            }
            call.respond(response)
        }
        get("/byName/{id}") {
            val ids=Integer.parseInt(call.parameters["id"])
            val query=data.from(employe).select().where { employe.id eq ids }
            call.respond(query)
        }
        delete("/delete/{name}"){
            val names=call.parameters["name"].toString()
            data.delete(employe){it.name eq names}
            call.respond("deleted successfully")
        }
        put("/update"){
            val empdetails = call.receive<EmployeeDTO>()
            val name1=empdetails.name
            val mail=empdetails.mail
            data.update(employe){
                set(it.mail,mail)
                where { it.name eq name1 }
            }
            call.respond("updated successfully")


        }
    }
}



