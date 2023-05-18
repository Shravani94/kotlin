package com.example.Model

import kotlinx.serialization.Serializable

@Serializable
data class AddressDTO (
    val addid:Int,
    val colony:String,
    val city:String,
    val state:String,
    val pincode:Int

    )