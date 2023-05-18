package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Address: Entity<Address> {
    val addid:Int
    val colony:String
    val city:String
    val state:String
    val pincode:Int
}
object Addresses:Table<Address>("addresses"){
    val addid=int("addid").primaryKey().bindTo { it.addid }
    val colony=varchar("colony").bindTo { it.colony }
    val city=varchar("city").bindTo { it.city }
    val state=varchar("state").bindTo { it.state }
    val pincode=int("pincode").bindTo { it.pincode }
}