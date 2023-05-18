import com.sun.xml.internal.ws.developer.Serialization
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Deferred
import kotlinx.serialization.Serializable

@Serializable
data class EmployeeData(
    val id: Int, val name: String, val mail: String
)

suspend fun main(args: Array<String>) {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) { json() }

    }


    val response: HttpResponse = client.get("http://127.0.0.1:8080/show").body()
    println(response)
    val reponse1: HttpResponse = client.get("http://127.0.0.1:8080/byName/1234355").body()
    println(reponse1)
    val response2: HttpResponse = client.get("http://127.0.0.1:8080/insert") {
        contentType(ContentType.Application.Json)
        setBody(EmployeeData(7, "Advaith", "annameni"))
    }
    println(response2)

    println(response.bodyAsText())


    println("Hello World!")

    println("Program arguments: ${args.joinToString()}")
}