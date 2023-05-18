package com.example

import com.example.dbconfig.DatabaseFactory
import com.example.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.ktorm.database.Database

fun main() { embeddedServer(Netty, port = 8080, host = "localhost") {
        configureSerialization()
        configureRouting()
        connection = DatabaseFactory.init()
    }.start(wait = true)
}
var connection: Database? = null


