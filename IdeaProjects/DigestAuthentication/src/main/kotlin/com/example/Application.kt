package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.server.auth.*
import io.netty.util.CharsetUtil.UTF_8
import java.security.MessageDigest

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)
fun getMd5Digest(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))

val myRealm = "Access to the '/' path"
val userTable: Map<String, ByteArray> = mapOf(
    "jetbrains" to getMd5Digest("jetbrains:$myRealm:foobar"),
    "admin" to getMd5Digest("admin:$myRealm:password")
)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
install(Authentication){

    //------------authentication digest-----------------

    digest("auth-digest") {
        realm= myRealm
        digestProvider{userName, realm ->userTable[userName]
        }
        validate { credentials ->if(credentials.userName.isNotEmpty()){
            CustomPrincipal(credentials.userName,credentials.realm)
        }else{
            null
        }
        }
    }
    //______________baarer_________________
    bearer("auth-bearer") {
        realm = "Access to the '/' path"
        authenticate { tokenCredential ->
            if (tokenCredential.token == "abc123") {
                UserIdPrincipal("jetbrains")
            } else {
                null
            }
        }
    }

}
    configureRouting()
}
data class CustomPrincipal(val userName:String,val realm:String):Principal
