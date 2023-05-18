package com.techouts

sealed class Shape {
    class Circle(var radius: Float):Shape()
    class square(var side:Float):Shape()
    class Rectangle(var length:Float,var width:Float):Shape()
}
fun eva(e:Shape){
    when(e) {
        is Shape.Circle -> println("Area of the circle is ${3.14 * e.radius * e.radius}")
        is Shape.Rectangle ->println("Area of the rectangle is ${e.length*e.width}")
        is Shape.square->println("Area of the square is ${e.side*e.side}")
    }
}
fun main(agrs:Array<String>){
    var circle = Shape.Circle(5.0f)
    var square=Shape.square(20f)
    var rectangle=Shape.Rectangle(21f,45f)
    eva(circle)
    eva(rectangle)
    eva(square)
}