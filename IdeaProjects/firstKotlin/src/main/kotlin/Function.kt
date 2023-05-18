import java.util.Scanner

fun main(){
    var read=Scanner(System.`in`)
    println("enter a value")
    var a=read.nextInt()
    println("enter b value")
    var b=read.nextInt()
    addition(a,b)
    substraction(a)
    multiplication()
    println("enter c value")
    var c=read.nextDouble()
    division(a,c)

}
fun addition(a:Int=5,b:Int=6){
    println("with passing values")
    println("addintion of two number is ${a+b}")
}
fun substraction(a:Int=5,b:Int=50){
    println("with single value ")
    println("subtraction of two numbers is ${b-a}")

}
fun division(a:Int=70,c:Double){
    println("with named parameters")
    println("Division of two numbers is ${a/c}")
}
fun multiplication(a:Int=20,b:Int=10){
    println("with default parameters")
    var mul=a*b;
    println(mul)
}