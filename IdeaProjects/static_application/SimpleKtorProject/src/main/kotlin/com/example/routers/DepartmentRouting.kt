package com.example.routers

import com.example.models.DepartmentDTO
import com.example.services.DepartmentService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureDepartmentRouting() {
    val departmentService = DepartmentService()
    routing {
        route("/departments") {
            post("/addDepartments") {
                val params=call.receive<DepartmentDTO>()
                val noofRowsAffected=departmentService.saveDepartments(params)
                if(noofRowsAffected>0){
                    call.respond("Inserted successfully")
                }else{
                    call.respond("something went wrong")
                }

            }
            get("/getDepartments"){
                val departments=departmentService.getDepartment()
                call.respond(departments)
            }
        }
    }
}

