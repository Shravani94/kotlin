package com.example.plugins

import me.liuwj.ktorm.entity.Entity
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object employe:Table<Employees>("emp_table"){
    val id=int("id").primaryKey().bindTo { it.id }
    val name=varchar("name").bindTo { it.name }
    val mail=varchar("mail").bindTo { it.mail }
}

interface Employees :Entity<Employees>{
    val name:String
    val mail:String
    val id:Int
}