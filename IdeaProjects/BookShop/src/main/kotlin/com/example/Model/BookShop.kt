package com.example.Model

import kotlinx.serialization.Serializable

@Serializable
data class BookShop(
    val bookNo:Int,
    val bookName:String,
    val noofpages:Int,
    val bookPrice:Int,
    val book:BookDTO,
    val address:AddressDTO
)