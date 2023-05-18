package com.techouts

class IntegralRangeExample {
    fun ranges(){
        println("Integer Ranges from start to end")
        for(a in 1..7)
            print(a)
            println()
        println("character from start to end")
        for(arr in 'a'..'e')
            print(arr)
            println()

        println("integer in reverse order with downTo keyword")
        for(a in 5 downTo 1)
            print(a)
        println()
        println("integers in revers using downTo function")
        for(a in 5 downTo(0))
            print(a)
        println()
        println("characters in reverse order")
       /* for(arr in 'e'downTo 'a')
            print(arr)*/
        println("list using until keyword")
        for(a in 1 until 10)
            print(a)
        println()
        println("list using step keyword" )
        for(a in 1..20 step 2)
            print(a)
        println()
        println("using iterator function")
        var chr=(1..15)
        for(letter in chr)
            print(letter)


    }
}
fun main(agrs:Array<String>){
    var obj=IntegralRangeExample()
    obj.ranges()
}