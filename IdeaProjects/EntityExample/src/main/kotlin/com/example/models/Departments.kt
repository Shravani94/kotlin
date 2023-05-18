package com.example.models

import me.liuwj.ktorm.entity.Entity

interface Departments:Entity<Departments> {
    val departid:Int
    val departname:String
    val location:String
}