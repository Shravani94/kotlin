@file:JvmName("MyKotlinFile")
@file:JvmMultifileClass
package com.techouts

    fun volume(length:Int,width:Int):Int{
        println("length of the rectangle is $length")
        println("width of the rectangle is $width")
        var volumn=2*length*width
        println("volume of the rectangle is ${2*length*width}")
        return volumn
    }
