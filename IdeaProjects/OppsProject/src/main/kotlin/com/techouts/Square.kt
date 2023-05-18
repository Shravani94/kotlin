package com.techouts

import sun.security.util.Length

open class Square(var side:Int) {
    open fun area1() {
        var area = side * side
        println("sides of the squer is :$side")
        println("area of the square is :$area")
    }
}