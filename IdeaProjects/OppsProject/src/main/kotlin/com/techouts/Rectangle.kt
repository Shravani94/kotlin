package com.techouts

class Rectangle(open var length:Int,open var width:Int):Square(length) {
      fun area() {
          val area = length * width
          println("length of the rectangle : $length")
          println("width of the reactangle : $width")
          println("area of the rectangle is :$area")
     }
}
fun main(args:Array<String>){
     println("execution starts")
     val obj=Rectangle(10,20)
     println()
     obj.area()
     println()
     obj.area1()
     println()
     println("execution ends")
}
