package com.example.dbconfig

import com.example.models.StudentDTO
import com.example.services.StudentService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureStudentRouting(){
    val studentService=StudentService()
    routing {
        route("/students"){
            post("/addStudents"){
                val student=call.receive<StudentDTO>()
               val noOfRowsAffected=studentService.saveStudentWithDepartment(student)
                if(noOfRowsAffected>0){
                    call.respond("inserted successfully")
               }
                else{
                    call.respond("insertion failed")
                }
            }
            post("/saveStudent"){
                val student=call.receive<StudentDTO>()
                val noOfRowsAffected=studentService.saveStudent(student)
                if(noOfRowsAffected>0){
                    call.respond("student details inserted successfully")
                }
                else{
                    call.respond("not inserted")
                }
            }
            get("/getStudents"){
                val student=studentService.getStudents()
                call.respond(student)
            }
            get("/getStudentWithDepartment"){
                val studentDepartments=studentService.getStudentWithDepartment()
                call.respond(studentDepartments)
            }
        }
    }

}