package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.long
import org.ktorm.schema.varchar

interface Customer:Entity<Customer>{
    val id:Int
    val custName:String
    val custMail:String
    val custMobile:String
}
object customers: Table<Customer>("customers") {
    val id=int("id").bindTo { it.id }
    val name=varchar("name").bindTo { it.custName }
    val mail=varchar("mail").bindTo { it.custMail }
    val mobile=varchar("mobile").bindTo { it.custMobile }

}