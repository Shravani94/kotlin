fun main(args:Array<String>){
    var arr= listOf<Int>(-1,-2,-3,-4,5,6,7,8)
    var arr1= listOf<String>("Sravani","Kotlin","java")
    fun isPositive(x:Int)=x>0
fun isPositive(x:String)=x=="kotlin"||x=="Kotlin"
    println(arr.filter (::isPositive)  )
    println()
    println("overloading function")
    println(arr1.filter (::isPositive))
}

