package com.example.plugins

import kotlinx.serialization.Serializable

@Serializable
data class EmployeeDTO(val name:String, val mail:String, val id:Int)