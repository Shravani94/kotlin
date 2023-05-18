package com.example.dbconfig

import me.liuwj.ktorm.database.Database
import java.sql.Driver

val database=Database.connect(
    url = "jdbc:mysql://localhost:3306/spring",
    driver = "com.mysql.jdbc.Driver",
    user = "root",
    password = "root"
)
