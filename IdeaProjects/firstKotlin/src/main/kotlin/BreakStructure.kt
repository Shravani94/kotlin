fun main(){
    println("labeled break example")
    loop@for(i in 1..5){
        for(j in 1..7){
            println("i is $i nad j is $j")
            if(i==4){
                break@loop
            }
            println("i is $i ad j is $j")
        }
    }
    println()
    println("this example for labeled continue")
    loop1@for(k in 7..12){
        for(l in 8..13){
            println("k is $k and l is $l")
            if(k==11){
                continue@loop1
            }
            println("before condition satisfied")
        }
    }
}