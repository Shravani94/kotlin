package com.example.dbconfiguration

import me.liuwj.ktorm.database.Database

object DatabaseConnection {
    val driver="com.mysql.cj.jdbc.Driver"
    val url="jdbc:mysql://localhost:3306/kotlin"
    val user="root"
    val password="root"
    val database=Database.connect(url, driver,user,password)
}