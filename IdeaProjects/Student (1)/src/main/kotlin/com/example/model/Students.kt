package com.example.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object Students :Table<Nothing>("student_t"){
    val id=int("id").primaryKey()
    val firstname=varchar("firstName")
    val lastname=varchar("lastName")
    val mail=varchar("mail")
    val branch=varchar("branch")
}