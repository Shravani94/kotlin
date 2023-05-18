
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.internal.readJson
import model.StudentDTO

@OptIn(InternalSerializationApi::class)
suspend fun main(args: Array<String>) {
    val client = HttpClient(CIO) {
        install(Auth) {
            basic {
                credentials {
                    BasicAuthCredentials(username = "admin", password = "admin")
                }
                realm = "Access to the '/' path"
            }
        }
        install(ContentNegotiation) {
            json()
        }
    }
    val insert: HttpResponse=client.post("http://127.0.0.1:8080/insert"){
        contentType(ContentType.Application.Json)
        val string="{\"name\":\"srava\",\"gender\":\"f\",\"number\":\"5454545454\",\"city\":\"ssss\",\"state\":\"ar\",\"country\":\"ar\",\"pincode\":505404}"
        setBody(string)
    }
    println("inserting data ${insert.status}")
    println(insert)

    val getAllStudents: HttpResponse = client.get("http://127.0.0.1:8080/students")
    println("getting all students r${getAllStudents.status}")
    println(getAllStudents)

    val updateWithRequestBody:HttpResponse=client.put("http://127.0.0.1:8080/updatestudents") {
        contentType(ContentType.Application.Json)
        val body = StudentDTO(1,"shravani","female","568956869","ajsgh","awr","AR",235546)
        val string="{\"id\":1,\"name\":\"shravani\",\"gender\":\"f\",\"number\":\"5454545454\",\"city\":\"ssss\",\"state\":\"ar\",\"country\":\"ar\",\"pincode\":324444}"
        setBody(string)
    }
    println("update student${updateWithRequestBody.status}")
    println(updateWithRequestBody)

    val getStudentWithPath:HttpResponse=client.get("http://127.0.0.1:8080"){
        url{
            appendPathSegments("studentwithId","1")
        }
    }
    println("getting student with pathparam ${getStudentWithPath.status}")
    println(getStudentWithPath)

    val getStudentWithQueryParam:HttpResponse=client.get("http://127.0.0.1:8080/studenname"){
        url{
           // parameters.append("id","1")
            parameters.append("name","srava")
        }
    }
    println("get students with query param ${getStudentWithQueryParam.status}")
    println(getStudentWithQueryParam)

}
