package com.example.entities

import com.example.entities.students.bindTo
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Student :Entity<Student>{
    val id:Int
    val name:String
    val gender:String
    val number:String
    val city:String
    val state:String
    val country:String
    val pincode:Int
}
object students:Table<Student>("student"){
    val id=int("id").primaryKey().bindTo { it.id }
    val name=varchar("name").bindTo { it.name }
    val gender=varchar("gender").bindTo { it.gender }
    val number=varchar("number").bindTo { it.number }
    val city=varchar("city").bindTo { it.city }
    val state=varchar("state").bindTo { it.state }
    val country=varchar("country").bindTo { it.country }
    val pincode=int("pincode").bindTo { it.pincode }
}