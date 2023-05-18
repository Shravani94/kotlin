package com.example.entities

import com.example.models.CustomerDTO
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Address:Entity<Address>{
    val addId:Int
    val id:Int
    val homeNo:String
    val village:String
    val state:String
    val customer: Customer
}
object Addresses:Table<Address>("address"){
    val addid=int("addId").bindTo { it.addId }
    val custid=int("custId").bindTo { it.id }
    val homeno=varchar("homeNo").bindTo { it.homeNo }
    val village=varchar("village").bindTo { it.village }
    val state=varchar("state").bindTo { it.state }
}