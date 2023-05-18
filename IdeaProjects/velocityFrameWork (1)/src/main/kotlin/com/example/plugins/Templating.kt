package com.example.plugins

import io.ktor.server.velocity.*
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
import org.apache.velocity.runtime.RuntimeConstants
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Application.configureTemplating() {
    install(Velocity) {
        setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath")
        setProperty("classpath.resource.loader.class", ClasspathResourceLoader::class.java.name)
    }
    routing {
        get("/index") {
            val sampleUser =User("shravani","annameni","s@gmail.com","sravani")
            call.respond(VelocityContent("templates/index.vl", mapOf("user" to sampleUser)))
        }
    }
    routing {
        get("/userDetails"){
            val formalParameters=call.receiveParameters()
            val fname=formalParameters.getOrFail("firstName")
            val lname=formalParameters.getOrFail("lastName")
            val mail=formalParameters.getOrFail("mailId")
            val password=formalParameters.getOrFail("password")
            /*call.respondText ("""FirstName $fname
                |lastName $lname
                |mailId $mail
                |password $password
            """.trimMargin())*/
            val sampleUser=User(fname,lname,mail,password)
            call.respond(VelocityContent("templates/index.vl", mapOf("user" to sampleUser)))


        }
    }
}
data class User(val firstName: String, val lastName: String,val mailId:String,val password:String)
