package com.example.plugins
import com.example.dbconfig.DatabaseConnection
import com.example.dbconfig.DatabaseConnection.database
import com.example.model.Student
import com.example.model.Students
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.dsl.select

fun Application.configureRouting() {
    val data=DatabaseConnection.database
    routing {
        route("student") {
            post("/add"){
                val studentDetails = call.receive<Student>()
                val id=studentDetails.id
                val firstName=studentDetails.firstName
                val lastName=studentDetails.lastName
                val mail=studentDetails.mail
                val branch=studentDetails.branch
                println("$id,$firstName,$lastName,$mail,$branch")
                data.insert(Students) {
                    set(it.id, id)
                    set(it.firstname, firstName)
                    set(it.lastname, lastName)
                    set(it.mail, mail)
                    set(it.branch, branch)
                }
                call.respond("inserted successfully")
            }
            get("/show"){
                val result=data.from(Students).select()
                call.respond(result)
            }
        }
    }
}
