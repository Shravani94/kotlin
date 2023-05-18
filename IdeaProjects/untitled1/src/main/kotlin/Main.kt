import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.logging.*


suspend fun main(args: Array<String>) {
    val client= HttpClient(CIO){
       // install(Logging)
        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS

        }
    }
    val response:HttpResponse =client.request("https://localhost:8081")
    println(response.bodyAsText())
    println("Hello World!")
    println(client.engine)
    println(client.attributes)
    client.close()

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}