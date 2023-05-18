package com.example.model
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object customers: Table<Nothing>("ktor_customer") {
    var id = int("id").primaryKey()
    val firstName = varchar("firstName")
    val lastName = varchar("lastName")
    val mailId = varchar("mailId")
}
