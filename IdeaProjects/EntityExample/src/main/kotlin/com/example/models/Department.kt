package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Department(
    val departid:Int,
    val departname:String,
    val location:String
)