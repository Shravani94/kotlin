package com.example.databaseconnection

import me.liuwj.ktorm.database.Database

object DatabaseConnecetion{
    val database = Database.connect(
        url="jdbc:mysql://localhost:3306/spring",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )
}