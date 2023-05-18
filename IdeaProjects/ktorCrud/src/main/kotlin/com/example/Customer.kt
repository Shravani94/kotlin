package com.example
import org.jetbrains.exposed.sql.*


class Customer(
    val id:Int,
    val firstName:String,
    val lastName:String,
    val mailId:String
)
object customers: Table() {
    val id=integer("id").autoIncrement()
    val firstName=varchar("firstName",50)
    val lastName=varchar("lastName",50)
    val mailId=varchar("mailId",100)
}