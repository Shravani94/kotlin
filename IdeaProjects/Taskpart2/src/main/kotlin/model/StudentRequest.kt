package model

import kotlinx.serialization.Serializable

@Serializable
data class StudentDTO (
    val id:Int,
    val name:String,
    val gender:String,
    val number:String,
    val city:String,
    val state:String,
    val country:String,
    val pincode:Int
)
