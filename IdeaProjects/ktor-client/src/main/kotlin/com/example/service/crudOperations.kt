package com.example.service

import com.example.service.client1.client
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.serialization.kotlinx.json.*

object client1{
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        install(Auth) {
            basic {
                credentials {
                    BasicAuthCredentials(username = "admin", password = "admin")
                }
                realm = "Access to the '/' path"
            }
        }
    }
}
suspend fun insertData(body: StudentDTO): String {
    println(body)

    val insert: HttpResponse =client.post("http://127.0.0.1:8080/insert"){
       contentType(ContentType.Application.Json)
        setBody(body)
    }
    return insert.bodyAsText()
}
suspend fun getAllstudent(body:StudentDTO):HttpResponse {
    val allStudents:HttpResponse= client.get("http://127.0.0.1:8080/studentsWithrequestbody"){
        contentType(ContentType.Application.Json)
        setBody(body)
    }
    return allStudents.body()
}
suspend fun getWithParam():HttpResponse {
    val studentWithParam:HttpResponse= client.get("http://127.0.0.1:8080"){
        url{
            appendPathSegments("studentwithId","1")
        }
    }
    return studentWithParam.body()
}
suspend fun getWithQueryParam():String{
    val studentWithQuery:HttpResponse= client.get("http://127.0.0.1:8080/studenname"){
        url{
            parameters.append("id","1")
            parameters.append("name","shravani")
        }
    }
    return studentWithQuery.bodyAsText()
}
suspend fun updatewithRequestBody(body:StudentDTO):String{
    val updatemessage:HttpResponse= client.put("http://127.0.0.1:8080/updatestudents"){
        contentType(ContentType.Application.Json)
        setBody(body)
    }
    return updatemessage.bodyAsText()
}
suspend fun updateWithQueryParam(body: StudentDTO):HttpResponse{
    val updatemessage:HttpResponse= client.put("http://127.0.0.1:8080/updatestudentsWithQuery"){
        contentType(ContentType.Application.Json)
        url{
            parameters.append("id","1")
        }
        setBody(body)
    }
    return updatemessage.body()
}
suspend fun deleteData(body:StudentDTO):HttpResponse{
    val deleteMessage:HttpResponse= client.delete("http://127.0.0.1:8080/remove"){
        contentType(ContentType.Application.Json)
        setBody(body)
    }
    return deleteMessage.body()

}




