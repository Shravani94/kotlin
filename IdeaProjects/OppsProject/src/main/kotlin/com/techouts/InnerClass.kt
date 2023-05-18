package com.techouts

class InnerClass {
    private  var name:String="Shravani"
    inner class InnerClassExample{
        var dept:String="computers"
        private var id:Int=102
        fun foo(){
            println("name is  from outerclass ${name}")
            println("id is $id")
            println("department is $dept")
        }
    }

    
}
fun main(args:Array<String>){
    var obj=InnerClass().InnerClassExample()
    obj.foo()


}