package com.example.models

data class AddressDTO(
    val addId:Int,
    val id:Int,
    val homeNo:String,
    val village:String,
    val state:String,
    val customer:CustomerDTO
)