package com.example.dbconfig

import org.ktorm.database.Database

object DatabaseConnection1 {
    val Driver= "com.mysql.cj.jdbc.Driver"
    val url ="jdbc:mysql://localhost:3306/kotlin"
    val userid ="root"
    val pass="root"
    val database=Database.connect(url, Driver,userid,pass)
}
