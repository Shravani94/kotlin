package com.example.models

data class StudentDTO(
    val roll_no:Int,
    val first_name:String,
    val last_name:String,
    val mail_id:String,
    val dept_no:Int,
    val department:DepartmentDTO
    )