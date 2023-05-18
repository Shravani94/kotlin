package com.example.routes

import com.example.dbconfiguration.DatabaseConnection
import com.example.entities.department
import com.example.entities.departmentBind
import com.example.models.Department
import com.example.models.Departments
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.dsl.map
import me.liuwj.ktorm.dsl.select

fun Application.departmentRouting(){
    val data=DatabaseConnection.database
    routing {
        route("/department"){
            post("/insert"){
                val dep=call.receive<Department>()
                val id=dep.departid
                val name=dep.departname
                val loc=dep.location
                data.insert(departmentBind){
                    set(it.departid,id)
                    set(it.departname,name)
                    set(it.location,loc)
                }
                call.respondText("department details inserted successfully")
            }
            get("/showAllDepartments"){
                val departments=data.from(departmentBind).select().map { row ->departmentBind.createEntity(row)  }
                call.respond(departments)
            }

        }
    }
}

