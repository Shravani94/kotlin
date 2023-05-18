package com.techouts
import com.techout.ExampleInteroperable;
class ExampleInter {
    fun swap(){
        var a=10;
        var b=20;
        var temp:Int?=null
        println("before swapping a is : $a and b is :$b")
        temp=a;
        a=b;
        b=temp;
        println("after swapping a is : $a and b is $b")
    }

}
fun main(agrs:Array<String>){
    //accessing getter and setter methods from java to kotlin
    var obj=ExampleInteroperable();
    obj.mailId="Shravani@gmail.com"
    obj.setMobileNo(6789054321);
    obj.name="Shravani Annameni"
    println("using getMethod()'s")
    println("name from java"+obj.getName())
    println("mailId from java "+obj.getMailId())
    println("mobile number from java "+obj.getMobileNo())
    println()
    println("by calling variable name")
    println("name from kotlin  "+obj.name)
    println("mailId from kotlin "+obj.mailId)
    println("mobileNo from kotlin "+obj.mobileNo)
    //calling array from java to kotlin
    var Intarr: IntArray = intArrayOf(1,2,3,4,5);
    println()
    println("calling array elements")
    var result=obj.sumOfArray(Intarr)
    println("Result is "+result)
    //accessing varargs from java to kotlin
    var agrs= intArrayOf(1,2,3,4,5,6,7);
    obj.varagrsexample("Hello Varargs",*agrs)

}