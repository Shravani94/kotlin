@file:JvmName("MyKotlinFile")
@file:JvmMultifileClass

package com.techouts
    fun area(length:Int,width:Int):Int{
        println("length of the rectangle is $length")
        println("width of the rectangle is $width")
        var area=length*width
        println("Area of the rectangle is ${length*width}")
        return area

}