import java.util.Scanner

fun main(args: Array<String>) {
    println("Hello World!")
   // Arrays.polindrom();
   val obj=Lexical();
    val read=Scanner(System.`in`)
    println("enter String")
    val str=read.next()
    val len=str.length
    Palindrome.polindrom(str,len)


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}