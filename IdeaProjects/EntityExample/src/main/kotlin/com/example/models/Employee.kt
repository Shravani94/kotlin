package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val empid:Int,
    val firstName:String,
    val lastName:String,
    val email:String,
    val role:String,
    val departid:Int,
    val department:Department
)