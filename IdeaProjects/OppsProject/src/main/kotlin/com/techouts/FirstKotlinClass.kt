package com.techouts

import java.util.Scanner

class FirstKotlinClass{
var account_no:Long=0
var amount:Float=0f
var name:String?=null
var read=Scanner(System.`in`)
var accountList:ArrayList<FirstKotlinClass> = ArrayList()
fun create(){
    var acc=FirstKotlinClass()
  println("enter account number")
  account_no= read.nextLong()
    println("enter amount")
    amount= read.nextFloat()
    println("enter account holder name")
    name= read.next()
}

}
fun main(arg:Array<String>){
  println("hello")
  var obj=FirstKotlinClass().create()
  println(obj)

}