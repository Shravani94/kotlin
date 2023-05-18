package com.example.Model

import kotlinx.serialization.Serializable

@Serializable
data class BookDTO(
    val name:String,
    val author:String,
    val noOfChap:Int,
    val yearOfPublishing:Int
    )