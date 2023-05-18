fun main(){
    var num1=10;
    var num2=20;
    println("Arthemtic operations")
    println("addition of $num1 and $num2 is ${num1+num2}")
    println("subtration of $num1 and $num2 is ${num1.minus(num2)}")
    println("multipication of $num1 and $num2 is ${num1.times(num2)}")
    println("division of $num1 by $num2 is ${num1/num2}")
    println("remainder og $num2 by $num1 is ${num2.rem(num1)}")
    println()
    println("relational operations")
    println("")
    var a = 5
    var b = 10
    var max = if (a > b) {
        println("a is greater than b.")
        a
    } else{
        println("b is greater than a.")
        b
    }
    println("max = $max")
    println()
    println("unary operations")
    var c=10
    var d=5
    var flag = true
    println("+a :"+ +c)
    println("-b :"+ -d)
    println("++a :"+ ++c)
    println("--b :"+ --d)
    println("!flag :"+ !flag)
    println()
    println("assigment operations")
    var e =20;var f=5
    a+=b
    println("a+=b :"+ e)
    a-=b
    println("a-=b :"+ e)
    a*=b
    println("a*=b :"+ e)
    a/=b
    println("a/=b :"+ e)
    a%=b
    println("a%=b :"+ e)
    println()
    println("logical operations")
    var g=10
    var h=5
    var i=15
    var flag1 = false
    var result: Boolean
    result = (g>h) && (g>i)
    println("(g>h) && (g>i) :"+ result)
    result = (g>h) || (g>i)
    println("(g>h) || (g>i) :"+ result)
    result = !flag1
    println("!flag1 :"+ result)
    println()
    println("bitwise operations")
    var j=10
    var k=2

    println("a.shl(b): "+j.shl(k))
    println("a.shr(b): "+j.shr(k))
    println("a.ushr(b:) "+j.ushr(k))
    println("a.and(b): "+j.and(k))
    println("a.or(b): "+j.or(k))
    println("a.xor(b): "+j.xor(k))
    println("a.inv(): "+j.inv())

}