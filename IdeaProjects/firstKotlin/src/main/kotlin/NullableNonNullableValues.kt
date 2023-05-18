import java.util.*

fun  main()
{
nonNullable()
    nullable()
}
fun nonNullable(){
    var read= Scanner(System.`in`)
    println("enter String value")
    var str:String=read.nextLine()
    //Exception concept with try and catch
    try{
    var result=if(str!=null) {
        println("length of the String is=${str.length}")
        println("value of the String is $str")
    }else{
        println("String is null")
    }
    }catch(e:Exception){
        println("String is null")
    }
    finally{
        println("finally nonnullabel function was excecuted")
    }
}
fun nullable(){
    var str1: String? ="""Hello
        #wecome to Kotline
        #we are no String and Nullable values
    """.trimMargin("#")
    var result2=if(str1!=null) {
        println("length of the String is ${str1.length}")
        println("the String is $str1")
    }
    //here throws concept was applied
    else{
        throw Exception("string is null")
    }
    str1=null
    result2=if(str1!=null) {
        println("length of the String is ${str1.length}")
        println("the String is $str1")
    }
    //here throws concept was applied
    else{
        throw Exception("string is null")
    }

}