package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.jetbrains.exposed.sql.Database

val dao = DAOFacadeDatabase(Database.connect("jdbc:mysql://localhost:3306/spring", driver = "com.mysql.jdbc.Driver",username="root",password="root")

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
    dao.init()

}.start(wait = true)

fun Application.module() {
    configureRouting()

}
